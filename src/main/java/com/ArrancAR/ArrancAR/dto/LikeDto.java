package com.ArrancAR.ArrancAR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LikeDto {

    private Long idUser;

    private Long idVehicle;
}
