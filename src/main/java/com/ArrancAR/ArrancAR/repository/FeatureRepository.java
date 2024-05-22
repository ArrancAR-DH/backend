package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

    Optional<Feature> findByName (String name);

}
