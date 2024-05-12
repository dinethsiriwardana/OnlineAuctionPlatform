package com.group04.OnlineAuctionPlatform.img;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequest {

    MultipartFile file;
    Long itemId;
    public FileUploadRequest(MultipartFile file, Long itemId) {
    }
}
