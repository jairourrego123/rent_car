package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Client;
import com.jairo.renta_car.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
            if(client.getIdClient()!= null){

                Optional<Client> tempId = clientRepository.getById(client.getIdClient());
                if (tempId.isPresent()) // There is a client in the database with the same id
                    return client;
                if (client.getEmail()!=null){
                    //todo validate regex[a-z0-9]^*@dpmain.com
                    Optional<Client> tempEmail= clientRepository.getByEmail(client.getEmail());
                    if (tempEmail.isPresent()) // There is a client in the database with the same email
                        return client;
                }
                if (client.getNickname()!=null){
                    Optional<Client> tempNickName= clientRepository.getByNickName(client.getNickname());
                    if (tempNickName.isPresent()) // There is a client in the database with the same nickname
                        return client;
                }

                if ((client.getName()!=null) && (client.getAddress()!=null) && (client.getPhones()!=null)
                        && (client.getPassword()!=null)){
                        return clientRepository.save(client);
                }
                else
                    return client;
            }
            else
                return client;
    }
    public Client updateClient (Client client){
        if(client.getIdClient()!=null){
            Optional<Client> temp = getClientById(client.getIdClient());
            if(temp.isPresent()){
                if(client.getName()!=null)
                    temp.get().setName(client.getName());
                if (client.getAddress()!=null)
                    temp.get().setAddress(client.getAddress());
                if (client.getPhones()!=null)
                    temp.get().setPhones(client.getPhones());
                if (client.getPassword()!=null)
                    temp.get().setPassword(client.getPassword());
                if (client.getEmail()!=null) {
                    Optional<Client> tempEmail = getClientByEmail(client.getEmail());
                    if (tempEmail.isPresent()){
                        return client;
                    }
                    temp.get().setEmail(client.getEmail());

                }
                return clientRepository.save(temp.get());
            }
            else
                return client;
        }
        else
            return client;
    }
    public boolean deleteClient(Integer clientId){
        Boolean success = getClientById(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;
    }
}
