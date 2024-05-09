package com.ArrancAR.ArrancAR.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column
    private String name;

    @Column
    private String description;

    public Role(Long idRole, String name, String description) {
        this.idRole = idRole;
        this.name = name;
        this.description = description;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role() {
    }
}