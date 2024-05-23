package com.ArrancAR.ArrancAR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "model")
@Data
@Getter
@Setter
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;

    @Column
    private String name;

    @OneToMany(mappedBy = "model",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vehicle> vehicles;

    public Model(Long idModel, String name) {
        this.idModel = idModel;
        this.name = name;
    }

    public Model(String name) {
        this.name = name;
    }

    public Model() {
    }
}
