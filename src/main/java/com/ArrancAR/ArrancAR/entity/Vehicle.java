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

<<<<<<< HEAD
    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Model model, Type type, Brand brand, List<Img_urls> imgUrls, Set<Booking> bookings) {
=======
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_imagelist", referencedColumnName = "idImageList")
    private Image image;

    public Vehicle(Long idVehicle, String plate, String description, Boolean reserved, Double price, Set<Booking> bookings, Model model, Type type, Brand brand, Image image) {
>>>>>>> dc647a77e659e2f3ead93bb6aab1dd725703a90a
        this.idVehicle = idVehicle;
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
        this.bookings = bookings;
        this.model = model;
        this.type = type;
        this.brand = brand;
<<<<<<< HEAD
        this.imgUrls = imgUrls;
        this.bookings = bookings;
    }

    public Vehicle(String plate, String description, Boolean reserved, List<Img_urls> imgUrls, Set<Booking> bookings, Model model, Type type, Brand brand) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.imgUrls = imgUrls;
=======
        this.image = image;
    }

    public Vehicle(String plate, String description, Boolean reserved, Double price, Set<Booking> bookings, Model model, Type type, Brand brand, Image image) {
        this.plate = plate;
        this.description = description;
        this.reserved = reserved;
        this.price = price;
>>>>>>> dc647a77e659e2f3ead93bb6aab1dd725703a90a
        this.bookings = bookings;
        this.model = model;
        this.type = type;
        this.brand = brand;
        this.image = image;
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

<<<<<<< HEAD
    public List<Img_urls> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<Img_urls> imgUrls) {
        this.imgUrls = imgUrls;
=======
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
>>>>>>> dc647a77e659e2f3ead93bb6aab1dd725703a90a
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
<<<<<<< HEAD
=======

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


>>>>>>> dc647a77e659e2f3ead93bb6aab1dd725703a90a
}
