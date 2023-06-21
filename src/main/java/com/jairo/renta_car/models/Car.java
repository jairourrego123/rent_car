package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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



}
