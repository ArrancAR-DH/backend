package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Model;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.service.ModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Model")
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/all")
    public List<Model> listModels() {
        return modelService.listModels();
    }

    @PostMapping
    public ResponseEntity<Model> addModel(@RequestBody Model model) throws DataIntegrityViolationException {
        Optional<Model> foundModel = modelService.findModelByName(model.getName());
        if(foundModel.isPresent()){
            throw new DataIntegrityViolationException("This model already exists");
        } else {
            return ResponseEntity.ok(modelService.addModel(model));
        }
    }
}
