package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Long> {

    Optional<Model> findByName(String name);

}
