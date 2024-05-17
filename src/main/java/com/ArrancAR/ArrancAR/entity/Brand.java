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
    @JoinColumn(name = "id_image", referencedColumnName = "id")
    private Img_urls imgUrl;

    public Brand(Long idBrand, String name, Img_urls imgUrl) {
        this.idBrand = idBrand;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Brand(String name, Img_urls imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
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

    public Img_urls getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Img_urls imgUrl) {
        this.imgUrl = imgUrl;
    }
}