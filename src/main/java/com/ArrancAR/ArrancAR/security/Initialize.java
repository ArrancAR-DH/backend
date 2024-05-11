package com.ArrancAR.ArrancAR.security;

import com.ArrancAR.ArrancAR.entity.*;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import com.ArrancAR.ArrancAR.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class Initialize implements ApplicationRunner {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
