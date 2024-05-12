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
    private Long idImageList;

    @Column
    private List<String> imageUrls;

    public Image(Long idImageList, List<String> imageUrlList, Vehicle vehicle) {
        this.idImageList = idImageList;
        this.imageUrls = imageUrlList;
    }

    public Image(List<String> imageUrlList, Vehicle vehicle) {
        this.imageUrls = imageUrlList;
    }

    public Image() {
    }
}