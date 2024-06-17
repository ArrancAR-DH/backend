package com.ArrancAR.ArrancAR.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "features")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeature;

    @Column
    private String name;
}
