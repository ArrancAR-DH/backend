package com.ArrancAR.ArrancAR.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicle")
@Data
@Getter
@Setter

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
    @Column
    private Double price;

    //ESTE ES UN COMENTARIO PARA LA PREUBA DE INFRA DE JAVI GOD
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle")
    private List<Img_urls> imgUrls;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_model")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @ManyToMany
    @JoinTable(
            name = "vehicle_features",
            joinColumns = @JoinColumn(name = "id_vehicle", referencedColumnName = "idVehicle"),
            inverseJoinColumns = @JoinColumn(name = "id_feature", referencedColumnName = "idFeature" )
    )
    private Set<Feature> features = new HashSet<>();

    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Double price, Model model, Type type, Brand brand) {
        this.idVehicle = idVehicle;
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle(String plate, String description, Boolean reserved, Double price, Model model, Type type, Brand brand) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle(String plate, Model model, Type type, Brand brand) {
        this.plate = plate;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle() {
    }
}
