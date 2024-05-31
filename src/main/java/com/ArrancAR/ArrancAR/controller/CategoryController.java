package com.ArrancAR.ArrancAR.controller;

import com.ArrancAR.ArrancAR.entity.Category;
import com.ArrancAR.ArrancAR.exception.DataIntegrityViolationException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name= "Category")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryByName(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Category> foundCategory = categoryService.findCategoryById(id);
        if(foundCategory.isPresent()){
            return ResponseEntity.ok(foundCategory);
        } else {
            throw new ResourceNotFoundException("This category doesn't exist");
        }
    }

    @GetMapping("/all")
    public List<Category> listCategories() {
        return categoryService.listCategory();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory (@RequestBody Category category) throws DataIntegrityViolationException {

        Optional<Category> foundCategory = categoryService.findCategoryByName(category.getName());
        if(foundCategory.isPresent()){
            throw new DataIntegrityViolationException("This category already exists");
        } else {
            return ResponseEntity.ok(categoryService.saveCategory(category));
        }

    }


}
