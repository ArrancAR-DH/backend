package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Type;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.service.TypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Type")
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    public List<Type> listTypes() {
        return typeService.listTypes();
    }

    @PostMapping
    public ResponseEntity<Type> addType(@RequestBody Type type) throws DataIntegrityViolationException {
        Optional<Type> foundType = typeService.findTypeByName(type.getName());
        if(foundType.isPresent()){
            throw new DataIntegrityViolationException("This type already exists");
        } else {
            return ResponseEntity.ok(typeService.addType(type));
        }
    }
}
