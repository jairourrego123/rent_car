package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class CarServices {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar(){
    return carRepository.getAll();
    }
    public List<Car> getAllCarByYear(Integer year){

        if (year<1950)
            return  null;
        return carRepository.getAllByYear(year);
        
    }

   public Optional<Car> getCarById(Integer carId){
        
        return carRepository.getById(carId);

   }

   public Optional<Car> getCarByPlate(String plate){

       // TODO: 25/06/2023 Verify plate  regular expression (regex):[A-Z]^3-[0-9]^3
       return carRepository.getByPlate(plate);

   }

    public Car insertCar(Car car){ // Guardar informacion

    }

    public Car updateCar(Car car){ // Actualizar

    }
    public boolean deleteCar(Integer carId){
     Boolean success = getCarById(carId).map(car -> {
         carRepository.delete(car);
         return true;

     }).orElse(false);
     return success;
    }

}
