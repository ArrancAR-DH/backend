package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.repository.FeatureRepository;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;
    private FeatureRepository featureRepository;

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findVehicleById(Long idVehicle) {
        return vehicleRepository.findById(idVehicle);
    }

    public Optional<Vehicle> findVehicleByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> listVehicles() {
        return vehicleRepository.findAll();
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
