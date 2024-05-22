package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.dto.RegisterDto;
import com.ArrancAR.ArrancAR.entity.Role;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.exception.AuthException;
import com.ArrancAR.ArrancAR.repository.RoleRepository;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public String register (RegisterDto registerDto) {
        // check username is already exists in database
        if(userRepository.existsByUserName(registerDto.getUsername())){
            throw new AuthException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new AuthException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setFirstName(registerDto.getName());
        user.setLastName(registerDto.getLastName());
        user.setUserName(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            throw new AuthException(HttpStatus.BAD_REQUEST, "Role not found!");
        }
        user.setRole(role);

        userRepository.save(user);

        return "User Registered Successfully!.";
    }
}
