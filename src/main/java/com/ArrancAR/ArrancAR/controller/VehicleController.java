package com.ArrancAR.ArrancAR.controller;


import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> getVehicleById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(id);
        if(foundVehicle.isPresent()) {
            return ResponseEntity.ok(foundVehicle);
        } else {
            throw new ResourceNotFoundException("This vehicle doesn't exist");
        }
    }

    @GetMapping("/all")
    public List<Vehicle> listVehicles() {
        return vehicleService.listVehicles();
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) throws DataIntegrityViolationException {
        System.out.println(vehicle);
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleByPlate(vehicle.getPlate());
        if(foundVehicle.isPresent()){
            throw new DataIntegrityViolationException("This vehicle already exists");
        } else {
            return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(id);
        if(foundVehicle.isPresent()) {
            vehicleService.deleteVehicleById(id);
            return ResponseEntity.ok("Vehicle successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The vechile can't be eliminated because it doesn't exist");
        }
    }
}
