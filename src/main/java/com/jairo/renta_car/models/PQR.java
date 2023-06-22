package com.jairo.renta_car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="pqrs")
public class PQR implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPqr;
    @Column(length = 20)
    private  String type;
    @Column(length = 300)
    private String content;

    //TODO add relation with client
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties("pqrs")
    private Client clientFK;

    public Integer getIdPqr() {
        return idPqr;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Client getClientFK() {
        return clientFK;
    }

    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }
}

