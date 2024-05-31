package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;
    @Column
    private LocalDate startsOn;
    @Column
    private LocalDate endsOn;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "idUser")
    private User user;

    @Column(name = "id_vehicle")
    private Long idVehicle;

}
