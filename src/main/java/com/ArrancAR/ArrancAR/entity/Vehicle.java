package com.ArrancAR.ArrancAR.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicle")
@Data
@Getter

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    @Column
    private String plate;
    @Column
    private String description;
    @Column
    private Boolean reserved;
    @Column
    private Double price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle")
    private List<Img_urls> imgUrls;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_model", referencedColumnName = "idModel")
    private Model model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_type", referencedColumnName = "idType")
    private Type type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_brand", referencedColumnName = "idBrand")
    private Brand brand;

    @ManyToMany
    @JoinTable(
            name = "vehicle_features",
            joinColumns = @JoinColumn(name = "id_vehicle", referencedColumnName = "idVehicle"),
            inverseJoinColumns = @JoinColumn(name = "id_feature", referencedColumnName = "idFeature")
    )
    private Set<Feature> features = new HashSet<>();

    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Double price, Model model, Type type, Brand brand) {
        this.idVehicle = idVehicle;
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle(String plate, String description, Boolean reserved, Double price, Model model, Type type, Brand brand) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle() {
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Img_urls> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<Img_urls> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}
