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



    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Client getClientFK() {
        return clientFK;
    }

    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    public Car getCarFK() {
        return carFK;
    }

    public void setCarFK(Car carFK) {
        this.carFK = carFK;
    }

    public Set<Employ> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employ> employees) {
        this.employees = employees;
    }

    public Integer getIdReservation() {
        return idReservation;
    }
}
