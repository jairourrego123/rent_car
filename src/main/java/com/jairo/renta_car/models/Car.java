package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity // indica que la siguiente clase es una entidad
@Table(name = "cars") // Nombre de la tabla en la base de datos
public class Car implements Serializable { // serializa la clase
    @Id // indica que el siguiente atributo es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementable
    private Integer idCar; // atributo idCar (Llave primaria)
    @Column(length = 50,nullable = false) // Agrega propiedades y restricciones a la columna
    private String plate;
    @Column(length = 4,nullable = false)
    private Integer year;
    @Column(length = 10,nullable = false)
    private String brand;

    private String color;
    @ManyToOne
    @JoinColumn(name = "CarTypeId") //Llave primaria en la otra tabla
    @JsonIgnoreProperties("cars") // Ignora las propiedades de ese campo
    private CarType carTypeFK; // nombre del atributo

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "carFK")
    @JsonIgnoreProperties("carFK")
    private List<Reservation> reservations;


    public Integer getIdCar() {
        return idCar;
    }



    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getCarTypeFK() {
        return carTypeFK;
    }

    public void setCarTypeFK(CarType carTypeFK) {
        this.carTypeFK = carTypeFK;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
