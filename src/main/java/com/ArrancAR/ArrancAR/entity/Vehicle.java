package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
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

    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY)
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

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_imagelist", referencedColumnName = "idImageList")
    private Image image;

    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Model model, Type type, Brand brand, Image image) {
        this.idVehicle = idVehicle;
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Vehicle(String plate, String description, Boolean reserved, Model model, Type type, Brand brand, Image image) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
