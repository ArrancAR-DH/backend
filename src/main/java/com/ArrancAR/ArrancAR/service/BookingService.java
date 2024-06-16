package com.ArrancAR.ArrancAR.service;


import com.ArrancAR.ArrancAR.dto.BookingRequestDto;
import com.ArrancAR.ArrancAR.dto.BookingResponseDto;
import com.ArrancAR.ArrancAR.entity.Booking;
import com.ArrancAR.ArrancAR.entity.User;
import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.mapper.BookingDtoConverter;
import com.ArrancAR.ArrancAR.repository.BookingRepository;
import com.ArrancAR.ArrancAR.repository.VehicleRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;
@Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    BookingDtoConverter bookingDtoConverter;

    @Autowired
    BookingRepository bookingRepository;

    public BookingResponseDto saveBooking(BookingRequestDto bookingRequestDto) {

        Vehicle vehicle = checkVehicleExists(bookingRequestDto.getIdVehicle());
        User user = checkUserExists(bookingRequestDto.getIdUser());

        Booking newBooking = new Booking();
        newBooking.setStartsOn(bookingRequestDto.getStartsOn());
        newBooking.setEndsOn(bookingRequestDto.getEndsOn());
        newBooking.setIdUser(bookingRequestDto.getIdUser());
        newBooking.setIdVehicle(bookingRequestDto.getIdVehicle());
        bookingRepository.save(newBooking);

        BookingResponseDto bookingResponseDto = bookingDtoConverter.convertBookingToBookingResponseDto(newBooking);

        //TODO
        //Agregar envio de mail de confirmación

        return bookingResponseDto;
    }

    private Vehicle checkVehicleExists(Long idVehicle) {
        return vehicleService.findVehicleById(idVehicle).orElseThrow(() -> new ResourceNotFoundException("No se encontró vehículo con el id: " + idVehicle));
    }

    private User checkUserExists(Long idUser) {
        return userService.findUserById(idUser).orElseThrow(() -> new ResourceNotFoundException("No se encontró usuario con el id: " + idUser));
    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    public Optional<Booking> findBookingById(Long idBooking) {
        return bookingRepository.findById(idBooking);
    }

    public List<Vehicle> findAvailableVehicles(LocalDate startsOn, LocalDate endsOn){
      List<Booking> dateMatches = bookingRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startsOn, endsOn);

      List<Vehicle> allVehicles = vehicleRepository.findAll();

       List<Vehicle> availableVehicles  = allVehicles.stream()
               .filter(vehicle -> dateMatches.stream().noneMatch
               (bookings -> bookings.getVehicle().equals(vehicle))).collect(Collectors.toList());

       return availableVehicles;

    }
}
