package com.ArrancAR.ArrancAR.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.time.LocalDate;
@Entity
@Table(name="score")
@Getter
@Setter
@NoArgsConstructor

public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScore;

    @Column
    private Integer score;

    @Column
    private LocalDate date;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name="id_vehicle", referencedColumnName = "idVehicle")
    private Long idVehicle;

    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "idUser")
    private Long idUser;




}
