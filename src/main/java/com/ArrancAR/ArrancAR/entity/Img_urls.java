package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_urls")
public class Img_urls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String url;

    public Img_urls(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Img_urls(String url) {
        this.url = url;
    }

    public Img_urls() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
