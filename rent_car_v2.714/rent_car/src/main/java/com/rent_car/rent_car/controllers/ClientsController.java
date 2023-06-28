package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.Client;
import com.jairo.renta_car.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping("/all")
    public List<Client> getAllClient(){
        return clientServices.getAllClient();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Integer clientId){
        return clientServices.getClientById(clientId);
    }
    @GetMapping("/by_email/{email}")
    public Optional<Client> getClientByEmail(@PathVariable("email") String email){
        return clientServices.getClientByEmail(email);
    }

    @GetMapping("/by_nickname/{nickname}")
    public Optional<Client> getClientByNickName(@PathVariable("nickname") String nickName){
        return clientServices.getClientByNickName(nickName);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client client){
        return clientServices.insertClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return clientServices.updateClient(client);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteClient(@PathVariable("id") Integer clientId){
        return clientServices.deleteClient(clientId);
    }
}
