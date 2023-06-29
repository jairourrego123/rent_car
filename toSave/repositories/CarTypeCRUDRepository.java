package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeCRUDRepository extends CrudRepository<CarType,Integer> {
}
