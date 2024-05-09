package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String password;
    @Column
    private String email;
    @ManyToOne
    @JoinColumn(name="id_role", referencedColumnName = "idRole")
    private Role role;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }



    public User(Long idUser, String firstName, String lastName, String password, String email, Role role, Set<Booking> bookings) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String firstName, String lastName, String password, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User() {
    }


}
