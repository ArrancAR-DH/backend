package com.ArrancAR.ArrancAR.controller;


import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.BrandService;
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

@Tag(name= "Brand")
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Operation(summary = "List of all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brand list obtained correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Brand.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/all")
    public List<Brand> listBrands() {
        return brandService.listBrands();
    }
    @Operation(summary = "Registration of a new brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Brand stored correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Brand.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity <Brand> addBrand(@RequestBody Brand brand) throws DataIntegrityViolationException {
        Optional<Brand> foundBrand = brandService.findBrandByName(brand.getName());
        if(foundBrand.isPresent()){
            throw new DataIntegrityViolationException("This brand already exists");
        } else {
            return ResponseEntity.ok(brandService.addBrand(brand));
        }
    }
    
    @Operation(summary = "Deleting a brand by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Brand removed correctly",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Brand not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Brand> foundBrand = brandService.findBrandById(id);
        if(foundBrand.isPresent()) {
            brandService.deleteBrandById(id);
            return ResponseEntity.ok("Brand successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The brand can't be eliminated because it doesn't exist");
        }
    }
}
