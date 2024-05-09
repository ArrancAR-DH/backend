package com.ArrancAR.ArrancAR.entity;

import lombok.Data;

import javax.persistence.*;

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
