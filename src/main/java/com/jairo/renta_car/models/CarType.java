package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car_types")
public class CarType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carTypeId;
    @Column(length = 40,nullable = false,unique = true)
    private String line;
    @Column(length = 40,nullable = false)
    private  String level;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "carTypeFK") //Nombre del campo en la otra tabla que tendra la relacion
    @JsonIgnoreProperties("carTypeFK")//Ignora las propiedades de ese campo
    private List<Car> cars; //atributo de lista de carros que van hacer los campos que el va a tener

    public Integer getCarTypeId() {
        return carTypeId;
    }



    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
