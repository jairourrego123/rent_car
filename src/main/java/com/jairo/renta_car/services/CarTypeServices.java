package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.models.CarType;
import com.jairo.renta_car.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarTypeServices {

    @Autowired
    private CarTypeRepository carTypeRepository;

    public List<CarType> getAllCarType(){
        return  carTypeRepository.getAll();
    }

    public Optional<CarType> getCarTypeById(Integer carTypeId){
        if(carTypeId < 1) // Autoincrement does not have negative values
            return null;
        return  carTypeRepository.getById(carTypeId);
    }

    public CarType insertCarType(CarType carType){

    }
    public  CarType updateCartype(CarType carType){

    }

    public  boolean deleteCarType(Integer carTypeId){
    Boolean success = getCarTypeById(carTypeId).map(carType -> {
        carTypeRepository.delete(carType);
        return true;
    }).orElse(false);
    return success;
    }

}
