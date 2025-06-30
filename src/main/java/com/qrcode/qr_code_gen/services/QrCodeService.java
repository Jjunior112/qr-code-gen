package com.qrcode.qr_code_gen.services;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcode.qr_code_gen.dto.qrcode.qrCodeGenerateResponse;
import com.qrcode.qr_code_gen.ports.StoragePort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeService {
    private final StoragePort storagePort;

    public QrCodeService(StoragePort storagePort)
    {
        this.storagePort = storagePort;
    }
    public qrCodeGenerateResponse generateAndUploadQrCode(String text) throws IOException, WriterException {
        QRCodeWriter qrcodeWriter = new QRCodeWriter();


        BitMatrix bitMatrix = qrcodeWriter.encode(text,com.google.zxing.BarcodeFormat.QR_CODE, 200,200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix,"PNG",pngOutputStream);

        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        String url = storagePort.uploadFile(pngQrCodeData, UUID.randomUUID().toString(),"image/png");

        return new qrCodeGenerateResponse(url);

    }
}
