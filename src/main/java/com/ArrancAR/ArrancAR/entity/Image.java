package com.ArrancAR.ArrancAR.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column
    private String url;

    public Image(Long idImage, String url) {
        this.idImage = idImage;
        this.url = url;
    }
    public Image(String url) {
        this.url = url;
    }
    public Image() {
    }
}