package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Feature;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.FeatureService;
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

@Tag(name= "Feature")
@RestController
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @Operation(summary = "List of id feature")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feature obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feature.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Feature not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Feature>> getFeatureByName(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Feature> foundFeature = featureService.findFeatureById(id);
        if(foundFeature.isPresent()){
            return ResponseEntity.ok(foundFeature);
        } else {
            throw new ResourceNotFoundException("This feature doesn't exist");
        }
    }


    @Operation(summary = "List of all features")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feature list obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feature.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public List<Feature> listFeatures() {
        return featureService.listFeatures();
    }


    @Operation(summary = "Registration of a new feature")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Feature stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feature.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })

    @PostMapping
    public ResponseEntity<Feature> createFeature (@RequestBody Feature feature) throws DataIntegrityViolationException{

        Optional<Feature> foundFeature = featureService.findFeatureByName(feature.getName());
        if(foundFeature.isPresent()){
            throw new DataIntegrityViolationException("This feature already exists");
        } else {
            return ResponseEntity.ok(featureService.saveFeature(feature));
        }

    }

    @Operation(summary = "Deleting a feature by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Feature removed correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Feature not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeature(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Feature> foundFeature = featureService.findFeatureById(id);
        if(foundFeature.isPresent()) {
            featureService.deleteFeatureById(id);
            return ResponseEntity.ok("Feature successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The feature can't be eliminated because it doesn't exist");
        }
    }
    
    
    /*
    @Operation(summary = "Updating a feature")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feature updated correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Feature.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Feature not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })




     */




}
