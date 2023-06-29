package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarCRUDRepository extends CrudRepository<Car,Integer> {

    public Optional<Car> findByPlate(String plate);// busca por placa y es opcional por que pueda que reciba un valor como pueda que no
    public List<Car> findByYear(Integer year);// retornara una lista de carros de cierto año, esta lista puede estar vacia
}
