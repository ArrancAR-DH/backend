package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Feature;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.repository.FeatureRepository;
import com.ArrancAR.ArrancAR.service.FeatureService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Feature>> getFeatureByName(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Feature> foundFeature = Optional.ofNullable(featureService.findFeatureById(id));
        if(foundFeature.isPresent()){
            return ResponseEntity.ok(foundFeature);
        } else {
            throw new ResourceNotFoundException("This feature doesn't exist");
        }
    }

    @GetMapping("/all")
    public List<Feature> listFeatures() {
        return featureService.listFeatures();
    }

    @PostMapping

    public ResponseEntity<Feature> createFeature (@RequestBody Feature feature) throws DataIntegrityViolationException{

        Optional<Feature> foundFeature = featureService.findFeatureByName(feature.getName());
        if(foundFeature.isPresent()){
            throw new DataIntegrityViolationException("This feature already exists");
        } else {
            return ResponseEntity.ok(featureService.saveFeature(feature));
        }

    }




}
