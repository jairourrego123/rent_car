package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCRUDRepository extends CrudRepository<Client,Integer> {
}
