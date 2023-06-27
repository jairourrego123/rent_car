package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCRUDRepository extends CrudRepository<Client,Integer> {
    Optional<Client> findByEmail (String email);
    Optional<Client> findByNickName(String nickName);
}
