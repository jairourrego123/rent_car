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

    }
    public List<Car> getAllCarByYear(Integer year){
        
    }

   public Optional<Car> GetById(Integer id){

   }

   public Optional<Car> getCarByPlate(Spring plate){

   }

    public Car insertCar(Car car){

    }

    public Car updateCar(Car car){

    }
    public boolean deleteCar(Integer carId){

    }

}
