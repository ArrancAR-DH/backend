package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findByName(String name);
}
