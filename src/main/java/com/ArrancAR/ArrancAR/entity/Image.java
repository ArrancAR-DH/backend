package com.ArrancAR.ArrancAR.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "image")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column
    private String url;

    @ManyToOne
    private Vehicle vehicle;

    public Image(Long idImage, String url, Vehicle vehicle) {
        this.idImage = idImage;
        this.url = url;
        this.vehicle = vehicle;
    }

    public Image(String url, Vehicle vehicle) {
        this.url = url;
        this.vehicle = vehicle;
    }

    public Image() {
    }
}