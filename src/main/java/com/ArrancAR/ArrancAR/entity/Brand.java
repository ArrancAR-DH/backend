package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_imagelist", referencedColumnName = "idImageList")
    private Image image;

    public Brand(Long idBrand, String name, Image image) {
        this.idBrand = idBrand;
        this.name = name;
    }

    public Brand(String name, Image image) {
        this.name = name;
    }

    public Brand() {
    }
}