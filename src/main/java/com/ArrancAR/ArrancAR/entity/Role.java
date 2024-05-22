package com.ArrancAR.ArrancAR.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
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



}