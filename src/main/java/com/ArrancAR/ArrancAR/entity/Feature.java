package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "features")
@Data
@Getter
@Setter

public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeature;

    @Column
    private String name;

    @ManyToMany(mappedBy = "features")
    private Set<Vehicle> vehicles = new HashSet<>();

    public Feature(Long id, String name, Set<Vehicle> vehicles) {
        this.idFeature = id;
        this.name = name;
        this.vehicles = vehicles;
    }

    public Feature() {
    }
}
