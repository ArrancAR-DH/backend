package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Feature;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.FeatureService;
import com.ArrancAR.ArrancAR.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Vehicle")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private FeatureService featureService;

    @Operation(summary = "List of id vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehicle not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> getVehicleById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(id);
        if(foundVehicle.isPresent()) {
            return ResponseEntity.ok(foundVehicle);
        } else {
            throw new ResourceNotFoundException("This vehicle doesn't exist");
        }
    }

    @Operation(summary = "List of all vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle list obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public List<Vehicle> listVehicles() {
        return vehicleService.listVehicles();
    }

    @Operation(summary = "Registration of a new car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehicle stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
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

    @Operation(summary = "Deleting a vehicle by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vehicle removed correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehicle not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(id);
        if(foundVehicle.isPresent()) {
            vehicleService.deleteVehicleById(id);
            return ResponseEntity.ok("Vehicle successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The vehicle can't be eliminated because it doesn't exist");
        }
    }

    @PostMapping("{idVehicle}/features/{idFeature}")
    public ResponseEntity<Vehicle> addFeatureToVehicle(@PathVariable Long idVehicle, @PathVariable Long idFeature) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(idVehicle);
        Optional<Feature> foundFeature = featureService.findFeatureById(idFeature);

        if ( foundVehicle.isPresent() && foundFeature.isPresent() ){
            Vehicle vehicle = foundVehicle.get();
            Feature feature = foundFeature.get();
            vehicle.getFeatures().add(feature);
            return ResponseEntity.ok(vehicleService.addVehicle(vehicle));

    } else {
            throw new ResourceNotFoundException("The vehicle or the feature not found");
        }
    }

    @DeleteMapping("{idVehicle}/deletefeature/{idFeature}")
    public ResponseEntity<Vehicle> deleteFeatureFromVehicle(@PathVariable Long idVehicle, @PathVariable Long idFeature) throws ResourceNotFoundException {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(idVehicle);
        Optional<Feature> foundFeature = featureService.findFeatureById(idFeature);

        if ( foundVehicle.isPresent() && foundFeature.isPresent() ){
            Vehicle vehicle = foundVehicle.get();
            Feature feature = foundFeature.get();
            vehicle.addFeature(feature);
            return ResponseEntity.ok(vehicleService.addVehicle(vehicle));

        } else {
            throw new ResourceNotFoundException("The vehicle or the feature not found");
        }
    }

    @Operation(summary = "Updating a vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle updated correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehicle not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
        Optional<Vehicle> foundVehicle = vehicleService.findVehicleById(id);
        if(foundVehicle.isPresent()) {
            vehicle.setIdVehicle(id);
            vehicleService.updateVehicle(vehicle);
            return ResponseEntity.ok("Updated vehicle with ID: "+ vehicle.getIdVehicle());
        }
        return ResponseEntity.badRequest().body("Vehicle not found");
    }
}
