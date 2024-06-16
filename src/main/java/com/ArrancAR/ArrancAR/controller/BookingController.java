package com.ArrancAR.ArrancAR.controller;


import com.ArrancAR.ArrancAR.dto.BookingRequestDto;
import com.ArrancAR.ArrancAR.dto.BookingResponseDto;
import com.ArrancAR.ArrancAR.entity.Booking;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.exception.BusinessException;
import com.ArrancAR.ArrancAR.exception.ResourceNotFoundException;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import com.ArrancAR.ArrancAR.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name= "Booking")
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<BookingResponseDto> reservar(@RequestBody BookingRequestDto bookingRequestDto) throws BusinessException{
        if (bookingService.isVehicleAvailable(bookingRequestDto.getIdVehicle(),bookingRequestDto.getStartsOn(), bookingRequestDto.getEndsOn())) {
            BookingResponseDto bookingResponseDto = bookingService.saveBooking(bookingRequestDto);
            return ResponseEntity.ok(bookingResponseDto);
        } else {
            throw new BusinessException("No se puede realizar la reserva porque se superponen fechas por falta de disponibilidad. Por favor, elija otro rango de fechas");
        }
    }

    @DeleteMapping("/{idBooking}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long idBooking) throws ResourceNotFoundException {
        Optional<Booking> foundBooking = bookingService.findBookingById(idBooking);

        if(foundBooking.isPresent()) {

            Booking booking = foundBooking.get();

            Vehicle vehicle = vehicleRepository.findById(booking.getIdVehicle()).get();
            vehicle.getBookings().removeIf(vehicleBooked -> vehicleBooked.getIdBooking().equals(idBooking));

            User user = userRepository.findById(booking.getIdUser()).get();
            user.getBookings().removeIf(userBooked -> userBooked.getIdBooking().equals(idBooking));

            vehicleRepository.save(vehicle);
            userRepository.save(user);

            bookingService.deleteBookingById(idBooking);

            return ResponseEntity.ok("Booking successfully eliminated");
        } else {
            throw new ResourceNotFoundException("The booking can't be eliminated because it doesn't exist");
        }
    }
}
