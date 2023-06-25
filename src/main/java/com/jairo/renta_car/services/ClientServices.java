package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Client;
import com.jairo.renta_car.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
    return clientRepository.getAll();
    }
    public Optional<Client> getClientById(Integer clientId){
        if(clientId<0) // There is no negative IDs
            return  null;
        return  clientRepository.getById(clientId);
    }
    public Optional<Client> getClientByEmail(String email){
        //todo validate regex[a-z0-9]^*@dpmain.com
        return clientRepository.getByEmail(email);
    }
    public Optional<Client> getClientByNickName(String nickName){
        if(nickName.length()<4)
            return null;
        return clientRepository.getByNickName(nickName);
    }
    public Client insertClient (Client client){

    }
    public Client updateClient (Client client){

    }
    private boolean deleteClient(Integer clientId){
        Boolean success = getClientById(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;
    }
}
