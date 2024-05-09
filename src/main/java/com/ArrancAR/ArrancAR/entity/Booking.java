package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="booking")
@Data

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;
    @Column
    private LocalDate startsOn;
    @Column
    private LocalDate endsOn;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "idVehicle")
    private Vehicle vehicle;

    public Booking(Long idBooking, LocalDate startsOn, LocalDate endsOn, User user, Vehicle vehicle) {
        this.idBooking = idBooking;
        this.startsOn = startsOn;
        this.endsOn = endsOn;
        this.user = user;
        this.vehicle = vehicle;
    }

    public Booking(LocalDate startsOn, LocalDate endsOn, User user, Vehicle vehicle) {
        this.startsOn = startsOn;
        this.endsOn = endsOn;
        this.user = user;
        this.vehicle = vehicle;
    }

    public Booking() {
    }


}
