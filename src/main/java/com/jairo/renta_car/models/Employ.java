package com.jairo.renta_car.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employ implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployed;
    @Column(length = 50,nullable = false)
    private String name;

    private Boolean isAdmin = false;

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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
