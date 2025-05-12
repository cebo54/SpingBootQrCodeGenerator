package com.kaya.qrgenerator.controllers;

import com.google.zxing.WriterException;
import com.kaya.qrgenerator.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/qr")
public class QrCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping
    public String generateQRCode(@RequestParam String text) throws WriterException, IOException {
        String base64Image = qrCodeService.generateQRCodeBase64(text, 250, 250);
        return "<img src='data:image/png;base64," + base64Image + "'/>";
    }
}
