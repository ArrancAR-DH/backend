package com.ArrancAR.ArrancAR.controller;


import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> foundVehicle = vehicleService.getVehicleById(id);
        if(foundVehicle.isPresent()) {
            return ResponseEntity.ok(foundVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }

}
