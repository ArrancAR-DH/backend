package com.ArrancAR.ArrancAR.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name= "Booking")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/booking")
public class BookingController {


}
