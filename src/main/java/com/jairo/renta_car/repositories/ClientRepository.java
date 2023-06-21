package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Client;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    private List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();
    }

    private Optional<Client> getById(Integer clientId){
        return clientCRUDRepository.findById(clientId);
    }
    private Client save(Client client){
        return clientCRUDRepository.save(client);
    }
    private void delete(Client client){
        clientCRUDRepository.delete(client);
    }
}
