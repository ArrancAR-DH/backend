package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Long> {
    Optional<Category> findByName (String name);
}
