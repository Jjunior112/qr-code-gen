package com.qrcode.qr_code_gen.ports;

public interface StoragePort {
    String uploadFile(byte[] filedata, String fileName, String contentType);
}
