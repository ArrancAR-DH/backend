package com.ArrancAR.ArrancAR.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    @Column
    private String plate;
    @Column
    private String description;
    @Column
    private String year;
    @Column
    private Double price;

    //ESTE ES UN COMENTARIO PARA LA PREUBA DE INFRA DE JAVI GOD
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle")
    private List<Img_urls> imgUrls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_model")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehicle")
    private List<Feature> features;

    public void addFeature(Feature feature) {
        if (Objects.isNull(features)) {
            features = new ArrayList<>();
            features.add(feature);
        }
        else {
            features.add(feature);
        }
    }
}
