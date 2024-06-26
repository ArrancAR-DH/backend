package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Score;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import com.ArrancAR.ArrancAR.service.ScoreService;
import com.ArrancAR.ArrancAR.service.UserService;
import com.ArrancAR.ArrancAR.service.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name= "Score")
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<Score> saveScore(@RequestBody Score score) throws ResourceNotFoundException, DataIntegrityViolationException {
        Optional<User> foundUser = userService.findUserById(score.getIdUser());
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(score.getIdVehicle());

        if(foundVehicle.isPresent() && foundUser.isPresent()){
            return ResponseEntity.ok(scoreService.saveScore(score));

        } else {
        throw new DataIntegrityViolationException("This vehicle or user don't exists");
        }

    }

}
