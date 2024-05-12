package com.group04.OnlineAuctionPlatform.img;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import net.coobird.thumbnailator.Thumbnails; // Import for image compression
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Validated
@RestController
@RequestMapping(path = "apis/v1/file")
public class ImgManager {

    private final String uploadDirectory = "./src/main/java/com/group04/OnlineAuctionPlatform/img/store";

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("itemId") Long itemId) {
        try {
            // Generate a custom filename using the item ID
            String customName = itemId.toString();
            String filename = customName + ".png"; // Always save as PNG

            // Compress and save the file
            Path filepath = Paths.get(uploadDirectory, filename);
            compressAndSaveImage(file, filepath);

            return "File uploaded successfully!";
        } catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            // Load file as Resource
            Path filePath = Paths.get(uploadDirectory).resolve(filename).normalize();
            filePath  = Path.of(filePath + ".png");
            Resource resource = new UrlResource(filePath.toUri());

            // Check if the file exists
            if (resource.exists()) {
                // Determine the media type of the file
                MediaType mediaType = determineMediaType(filename);

                // Return the response with the file and appropriate content type
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline") // Set content disposition to inline
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Helper method to determine the media type of the file based on its extension
    private MediaType determineMediaType(String filename) {
        if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (filename.endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else {
            // Default to image/jpeg if the file extension is not recognized
            return MediaType.IMAGE_JPEG;
        }
    }

    // Helper method to compress and save the image
    private void compressAndSaveImage(MultipartFile file, Path filepath) throws IOException {
        // Compress the image to reduce its size
        BufferedImage compressedImage = Thumbnails.of(file.getInputStream())
                .size(1024, 768) // Specify the dimensions for compression
                .outputQuality(0.5) // Specify the quality of the compressed image
                .asBufferedImage();

        // Save the compressed image to the server
        ImageIO.write(compressedImage, "png", filepath.toFile());
    }
}
