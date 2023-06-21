package com.jairo.renta_car.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "emproyees")
public class Employ implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployed;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean is_admin = false;

    @ManyToMany(mappedBy = "employees")
    private Set<Reservation> reservations;// Conjunto en vez de una lista

}
