package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServices {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar(){

    }
    public List<Car> getAllCarByYear(){
        
    }
}
