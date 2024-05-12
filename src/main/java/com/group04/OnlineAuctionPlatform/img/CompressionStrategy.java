package com.group04.OnlineAuctionPlatform.img;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public interface CompressionStrategy {
    BufferedImage compressImage(InputStream inputStream) throws IOException;
}
