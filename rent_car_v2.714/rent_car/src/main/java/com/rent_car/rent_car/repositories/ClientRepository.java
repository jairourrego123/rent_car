package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;


    public List<Client> getAll(){

        return (List<Client>) clientCRUDRepository.findAll();
    }

    public Optional<Client> getById(Integer clientId){

        return clientCRUDRepository.findById(clientId);
    }
    public  Optional<Client> getByEmail(String email){
        return clientCRUDRepository.findByEmail(email);
    }

    public Optional<Client> getByNickName(String nickName){
        return clientCRUDRepository.findByNickName(nickName);
    }
    public Client save(Client client){

        return clientCRUDRepository.save(client);
    }
    public void delete(Client client){

        clientCRUDRepository.delete(client);
    }
}
