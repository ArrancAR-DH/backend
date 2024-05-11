package com.ArrancAR.ArrancAR;

import com.ArrancAR.ArrancAR.entity.*;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArrancArApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArrancArApplication.class, args);
	}

}
