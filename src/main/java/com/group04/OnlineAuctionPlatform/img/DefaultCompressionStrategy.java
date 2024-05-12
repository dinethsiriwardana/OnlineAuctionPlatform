package com.group04.OnlineAuctionPlatform.img;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class DefaultCompressionStrategy implements CompressionStrategy {
    @Override
    public BufferedImage compressImage(InputStream inputStream) throws IOException {
        return Thumbnails.of(inputStream)
                .size(1024, 768)
                .outputQuality(0.5)
                .asBufferedImage();
    }


}

// You can implement more strategies if needed, like AdvancedCompressionStrategy, etc.
