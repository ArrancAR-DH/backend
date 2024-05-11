package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findVehicleById(Long idVehicle) {
        return vehicleRepository.findById(idVehicle);
    }

    public Optional<Vehicle> findVehicleByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

    public Optional<Vehicle> findVehicleByBrand(Brand brand) {
        return vehicleRepository.findByBrand(brand);
    }

    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }
}
