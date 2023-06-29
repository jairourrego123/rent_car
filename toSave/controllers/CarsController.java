package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    private CarServices carServices;

    @GetMapping("/all")
    public List<Car> getAllCar(){
        return carServices.getAllCar();
    }
    @GetMapping("/all/{year}")
    public List<Car> getAllCarsByYear(@PathVariable("year") Integer year){
        return carServices.getAllCarsByYear(year);
    }

    @GetMapping("/by_id/{id}")
    public Optional<Car> getCarById(@PathVariable("id") Integer carId){
        return  carServices.getCarById(carId);
    }
    @GetMapping("/by_plate/{plate}")
    public Optional<Car> getCarByPlate(@PathVariable("plate") String plate){
        return carServices.getCarByPlate(plate);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Car insertCar (@RequestBody Car car){
        return carServices.insertCar(car);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car car){
        return carServices.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCar(@PathVariable("id") Integer carId){
        return carServices.deleteCar(carId);
    }

}
