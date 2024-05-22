package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "features")
@Data
@Getter

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

    public Long getId() {
        return idFeature;
    }

    public void setId(Long id) {
        this.idFeature = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
