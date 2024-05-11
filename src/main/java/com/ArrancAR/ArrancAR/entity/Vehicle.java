package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicle")
@Data

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    @Column
    private String plate;
    @Column
    private String description;
    @Column
    private Boolean reserved;
    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_model", referencedColumnName = "idModel")
    private Model model;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_type", referencedColumnName = "idType")
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_brand", referencedColumnName = "idBrand")
    private Brand brand;
    @OneToMany (mappedBy = "idImage",fetch = FetchType.LAZY)
    private Set<Image> images = new HashSet<>();

    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Model model, Type type, Brand brand, Image image) {
        this.idVehicle = idVehicle;
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle(String plate, String description, Boolean reserved, Model model, Type type, Brand brand, Image image) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle() {
    }
}
