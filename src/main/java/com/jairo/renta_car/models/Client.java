package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
public class Client  implements Serializable {
    @Id
    private Integer idClient;
    @Column(name = "names",length = 100,nullable = false)
    private String name;
    @Column(length = 50,nullable = false)
    private String address;
    @Column(length = 15, nullable = false)
    private  String phones;
    @Column(length = 50,nullable = false,unique = true)
    private  String email;

    private String nickname;
    private  String password;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFk")
    private List<PQR> pqrs;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFk")
    private List<Reservation> reservations;
}
