package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.dto.EmailDto;
import com.ArrancAR.ArrancAR.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/notification")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> receiveRequestEmail(@RequestBody EmailDto emailDto) {

        emailService.sendEmail(emailDto.getToUser(), emailDto.getFullName());
        return ResponseEntity.ok("Email enviado correctamente");
    }
}
