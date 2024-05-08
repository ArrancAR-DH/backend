package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="booking")
@Data

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservas;

    @Column
    private LocalDate startsOn;
    @Column
    private LocalDate endsOn;

}
