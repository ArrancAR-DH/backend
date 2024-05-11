package com.ArrancAR.ArrancAR.security;

import com.ArrancAR.ArrancAR.entity.*;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import com.ArrancAR.ArrancAR.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class Initialize implements ApplicationRunner {
    @Autowired
    VehicleService vehicleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Vehicle chevroletCamaro = new Vehicle("AGB ADD","Excelente estado",false,new Model("Camaro"),new Type("Sport"),new Brand("Chevrolet",new Image("https://imagenMarca")),new Image("https://imagenAUto"));
        vehicleService.addVehicle(chevroletCamaro);
    }
}
