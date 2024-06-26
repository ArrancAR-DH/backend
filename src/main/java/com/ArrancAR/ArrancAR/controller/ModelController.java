package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Model;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.ModelService;
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

@Tag(name= "Model")
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Operation(summary = "List of all models")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model list obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Model.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public List<Model> listModels() {
        return modelService.listModels();
    }


    @Operation(summary = "Registration of a new model")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Model stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Model.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Model> addModel(@RequestBody Model model) throws DataIntegrityViolationException {
        Optional<Model> foundModel = modelService.findModelByName(model.getName());
        if(foundModel.isPresent()){
            throw new DataIntegrityViolationException("This model already exists");
        } else {
            return ResponseEntity.ok(modelService.addModel(model));
        }
    }
    
    @Operation(summary = "Deleting a model by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Model removed correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Model> foundModel = modelService.findModelById(id);
        if(foundModel.isPresent()) {

            modelService.deleteModelById(id);
            return ResponseEntity.ok("Model successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The model can't be eliminated because it doesn't exist");
        }
    }
}
