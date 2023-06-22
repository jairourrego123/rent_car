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

    public Integer getIdEmployed() {
        return idEmployed;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
