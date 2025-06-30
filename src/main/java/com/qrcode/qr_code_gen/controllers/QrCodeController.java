package com.qrcode.qr_code_gen.controllers;

import com.qrcode.qr_code_gen.dto.qrcode.qrCodeGenerateRequest;
import com.qrcode.qr_code_gen.dto.qrcode.qrCodeGenerateResponse;
import com.qrcode.qr_code_gen.services.QrCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
        private final QrCodeService qrCodeService;
        public QrCodeController(QrCodeService qrCodeService)
        {
            this.qrCodeService = qrCodeService;
        }

        @PostMapping
        public ResponseEntity<qrCodeGenerateResponse> generate(@RequestBody qrCodeGenerateRequest request)
        {
            try{

                qrCodeGenerateResponse response = this.qrCodeService.generateAndUploadQrCode(request.url());

                return ResponseEntity.ok(response);

            }
            catch(Exception e){

                System.out.println(e);
                return ResponseEntity.internalServerError().build();
            }
        }




}
