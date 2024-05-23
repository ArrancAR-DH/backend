package com.ArrancAR.ArrancAR.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "type")
@Data
@Getter
@Setter
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @Column
    private String name;

    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vehicle> vehicles;

    public Type(Long idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public Type(String name) {
        this.name = name;
    }

    public Type() {
    }
}
