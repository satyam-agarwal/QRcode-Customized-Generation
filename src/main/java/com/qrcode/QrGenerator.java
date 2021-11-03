package com.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrGenerator {

    public static void main(String []args) throws WriterException, IOException {
        String qrCodeText = "www.example.com";
        String QRPath = "src\\main\\resources\\Qrcode.png";

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 300, 300);

        Path path = FileSystems.getDefault().getPath(QRPath);
        MatrixToImageWriter.writeToPath(byteMatrix,"PNG",path);
        System.out.println("QRCodePrinted");
    }
}

