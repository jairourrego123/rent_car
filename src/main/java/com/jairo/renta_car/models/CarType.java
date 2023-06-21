package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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

}
