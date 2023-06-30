package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

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

    private String nickName;
    private  String password;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFk")
    private List<PQR> pqrs;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "clientFK")
    @JsonIgnoreProperties("clientFk")
    private List<Reservation> reservations;

    public Integer getIdClient() {
        return idClient;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PQR> getPqrs() {
        return pqrs;
    }

    public void setPqrs(List<PQR> pqrs) {
        this.pqrs = pqrs;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
