package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.entity.Booking;
import com.ArrancAR.ArrancAR.entity.Brand;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.repository.BookingRepository;
import com.ArrancAR.ArrancAR.repository.FeatureRepository;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private BookingRepository bookingRepository;

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

    public List<Vehicle> listVehicles() {
        return vehicleRepository.findAll();
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public boolean isVehicleAvailable(Long idVehicle, LocalDate startsOn, LocalDate endsOn) {
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(idVehicle, startsOn, endsOn);
        return overlappingBookings.isEmpty();
    }

    public List<Vehicle> getAvailableVehicles(LocalDate startsOn, LocalDate endsOn) {
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        return allVehicles.stream()
                .filter(vehicle -> isVehicleAvailable(vehicle.getIdVehicle(), startsOn, endsOn))
                .collect(Collectors.toList());
    }
}
