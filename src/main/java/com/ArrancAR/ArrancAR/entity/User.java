package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter



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
    @Column
    private List<Long> likedVehicleIds;

    @ManyToOne
    @JoinColumn(name="id_role", referencedColumnName = "idRole")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private List<Booking> bookings;

    public User(Long idUser, String firstName, String userName, String lastName, String password, String email, Role role) {
        this.idUser = idUser;
        this.firstName = userName;
        this.userName = userName;
        this.password = password;
        this.lastName = userName;
        this.email = email;
        this.role = role;
    }

    public void addLikedVehicle(Long id) {
        if (Objects.isNull(likedVehicleIds)) {
            likedVehicleIds = new ArrayList<>();
            likedVehicleIds.add(id);
        }
        else {
            likedVehicleIds.add(id);
        }
    }

    public void dislikeVehicle(Long id) {
        likedVehicleIds.remove(id);
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getIdUser() {
        return idUser;
    }
}
