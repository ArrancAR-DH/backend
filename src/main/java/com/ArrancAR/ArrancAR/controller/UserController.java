package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.User;

import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<User> foundUser = userService.findUserById(id);
        if(foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser);
        } else {
            throw new ResourceNotFoundException("This user doesn't exist");
        }
    }
    @PostMapping("register")
    public ResponseEntity<User> addVehicle(@RequestBody User user) throws DataIntegrityViolationException {
        Optional<User> foundUser = userService.findUserByEmail(user.getEmail());
        if(foundUser.isPresent()){
            throw new DataIntegrityViolationException("This user already exists");
        } else {
            return ResponseEntity.ok(userService.addUser(user));
        }
    }
    @PutMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody User user) throws ResourceNotFoundException {
        Optional<User> foundUser= userService.findUserById(user.getIdUser());
        if(foundUser.isPresent()) {
            userService.updateUser(user);
            return ResponseEntity.ok("User updated successfully");
        }else{
            throw new ResourceNotFoundException("User doesn't exist");
        }
    }

}
