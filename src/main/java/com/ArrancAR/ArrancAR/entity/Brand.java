package com.ArrancAR.ArrancAR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;

    @Column
    private String name;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vehicle> vehicles;

    public Brand(Long idBrand, String name, Img_urls imgUrl) {
        this.idBrand = idBrand;
        this.name = name;
    }

    public Brand(String name, Img_urls imgUrl) {
        this.name = name;
    }

    public Brand() {
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}