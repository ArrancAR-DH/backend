package com.ArrancAR.ArrancAR.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;

    @Column
    private String name;

    @Column
    private Image image;

    public Brand(Long idBrand, String name, Image image) {
        this.idBrand = idBrand;
        this.name = name;
        this.image = image;
    }

    public Brand(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public Brand() {
    }
}