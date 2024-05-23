package com.ArrancAR.ArrancAR.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @Column
    private String name;


    public Type(Long idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public Type(String name) {
        this.name = name;
    }

    public Type() {
    }
}
