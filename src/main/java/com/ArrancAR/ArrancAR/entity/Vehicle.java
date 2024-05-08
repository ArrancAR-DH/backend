package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idVehicle;
    @Column
    private String plate;
    @Column
    private String model;
    @Column
    private String type;
}
