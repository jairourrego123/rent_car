package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar(){
    return carRepository.getAll();
    }
    public List<Car> getAllCarsByYear(Integer year){

        if (year<1950)
            return  null;
        return carRepository.getAllByYear(year);
        
    }

   public Optional<Car> getCarById(Integer carId){
        
        return carRepository.getById(carId);

   }

   public Optional<Car> getCarByPlate(String plate){
        if(Utilities.validatePlate(plate))

       // TODO: 25/06/2023 Verify plate  regular expression (regex):[A-Z]^3-[0-9]^3
            return carRepository.getByPlate(plate);
        else
            return null;

   }

    public Car insertCar(Car car){ // Guardar informacion
        if((car.getPlate()!=null) && (car.getYear()!=null) && (car.getBrand()!=null) &&
                (car.getColor() !=null ) && car.getCarTypeFK() !=null) {
            if (Utilities.validatePlate(car.getPlate())){
                Optional<Car> temp = carRepository.getByPlate(car.getPlate());
                if (temp.isEmpty() && car.getYear() > 1950)
                    return carRepository.save(car);
                else
                    return car;
            } else
                return car;
        }
            else
                return car;
    }

    public Car updateCar(Car car){ // Actualizar
        if (car.getIdCar()!= null){
            Optional<Car> temp = carRepository.getById(car.getIdCar());
            if (temp.isPresent()){
                if (car.getBrand()!= null)
                    temp.get().setBrand(car.getBrand());
                if (car.getColor()!= null)
                    temp.get().setColor(car.getColor());
                if (car.getCarTypeFK() !=null)
                    temp.get().setCarTypeFK(car.getCarTypeFK());
                return carRepository.save(temp.get());
            }
            else
                return car;
        }
        else
            return car;
    }
    public boolean deleteCar(Integer carId){
     Boolean success = getCarById(carId).map(car -> {
         carRepository.delete(car);
         return true;

     }).orElse(false);
     return success;
    }

}
