package com.ArrancAR.ArrancAR.controller;


import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.service.BrandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Brand")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/all")
    public List<Brand> listBrands() {
        return brandService.listBrands();
    }

    @PostMapping
    public ResponseEntity <Brand> addBrand(@RequestBody Brand brand) throws DataIntegrityViolationException {
        Optional<Brand> foundBrand = brandService.findBrandByName(brand.getName());
        if(foundBrand.isPresent()){
            throw new DataIntegrityViolationException("This brand already exists");
        } else {
            return ResponseEntity.ok(brandService.addBrand(brand));
        }
    }
}
