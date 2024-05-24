package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Type;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.service.TypeService;
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

@Tag(name= "Type")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Operation(summary = "List of all types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Type list obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Type.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public List<Type> listTypes() {
        return typeService.listTypes();
    }


    @Operation(summary = "Registration of a new type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Type stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Type.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Type> addType(@RequestBody Type type) throws DataIntegrityViolationException {
        Optional<Type> foundType = typeService.findTypeByName(type.getName());
        if(foundType.isPresent()){
            throw new DataIntegrityViolationException("This type already exists");
        } else {
            return ResponseEntity.ok(typeService.addType(type));
        }
    }

    /*
    @Operation(summary = "Deleting a Type by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Type removed correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Type not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    */
}
