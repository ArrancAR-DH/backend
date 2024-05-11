package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByBrand(Brand brand);
    Optional<Vehicle> findByPlate(String plate);

}
