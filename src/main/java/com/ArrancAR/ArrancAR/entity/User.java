package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor



public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column
    private String firstName;
    @Column (nullable = false, unique = true)
    private String userName;
    @Column
    private String lastName;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false, unique = true)
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


    public User(String firstName, String lastName, String password, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }
}
