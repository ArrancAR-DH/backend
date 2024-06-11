package com.ArrancAR.ArrancAR.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingRequestDto {

    @NotNull(message = "startsOn no puede ser null")
    private LocalDate sartsOn;

    @NotNull(message = "endsOn no puede ser null")
    private LocalDate endsOn;

    @NotNull(message = "idVehicle no puede ser null")
    private Long idVehicle;

    @NotNull(message = "idUser no puede ser null")
    private Long idUser;
}
