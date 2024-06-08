package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.dto.EmailDto;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.service.EmailService;
import com.ArrancAR.ArrancAR.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/notification")
public class MailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @PostMapping("/send")
    public ResponseEntity<String> receiveRequestEmail(@RequestBody EmailDto emailDto) {
        Optional<User> foundUser = userService.findUserByEmail(emailDto.getToUser());

        if (foundUser.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists with email: " + emailDto.getToUser());
        }

        try {
            emailService.sendEmail(emailDto.getToUser(), emailDto.getFullName());
            return ResponseEntity.ok("Email sent successfully to " + emailDto.getToUser());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }
}
