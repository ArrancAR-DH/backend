package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="booking")
@Getter
@Setter
@NoArgsConstructor

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;

    @Column
    private LocalDate startsOn;

    @Column
    private LocalDate endsOn;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_vehicle")
    private Long idVehicle;

}
