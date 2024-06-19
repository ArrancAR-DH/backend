package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.dto.LoginDto;
import com.ArrancAR.ArrancAR.dto.RegisterDto;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    // Build Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")

    public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
        User response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
