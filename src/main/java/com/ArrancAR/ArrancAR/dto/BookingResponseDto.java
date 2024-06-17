package com.ArrancAR.ArrancAR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingResponseDto {

    private Long idBooking;
    private LocalDate startsOn;
    private LocalDate endsOn;
    private Long idVehicle;
    private Long idUser;
}
