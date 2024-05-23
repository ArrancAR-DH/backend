package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "model")
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;

    @Column
    private String name;

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
