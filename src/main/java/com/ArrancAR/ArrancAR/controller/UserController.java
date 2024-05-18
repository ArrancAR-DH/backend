package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.User;

import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name= "User")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<User> foundUser = userService.findUserById(id);
        if(foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser);
        } else {
            throw new ResourceNotFoundException("This user doesn't exist");
        }
    }

    @Operation(summary = "Registration of a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping("register")
    public ResponseEntity<User> addVehicle(@RequestBody User user) throws DataIntegrityViolationException {
        Optional<User> foundUser = userService.findUserByEmail(user.getEmail());
        if(foundUser.isPresent()){
            throw new DataIntegrityViolationException("This user already exists");
        } else {
            return ResponseEntity.ok(userService.addUser(user));
        }
    }

    @Operation(summary = "Updating a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
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
