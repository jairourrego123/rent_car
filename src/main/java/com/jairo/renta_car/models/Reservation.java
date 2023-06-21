package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private String cost;
    private String grade;
    @Column(length = 200)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("reservations")
    private Client clientFK;

    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties("reservations")
    private Car carFK;

    @ManyToMany
    @JoinTable(
            name = "log_reservations", // nombre de la tabla
            joinColumns = @JoinColumn(name = "idReservation"), //primaryKey de esta entidad
            inverseJoinColumns = @JoinColumn(name = "idEmployed") // primaryKey de la otra entidad
    )
    private Set<Employ> employees;
}
