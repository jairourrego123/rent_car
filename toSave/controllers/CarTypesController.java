package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.models.CarType;
import com.jairo.renta_car.services.CarTypeServices;
import org.hibernate.query.ReturnableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car_types")
public class CarTypesController {
    @Autowired
    private CarTypeServices carTypeServices;

    @GetMapping("/all")
    public List<CarType> getAllCarType(){
        return carTypeServices.getAllCarType();
    }

    @GetMapping("/by_id/{id}")
    public Optional<CarType> getCarTypeById(@PathVariable("id") Integer carTypeId){
        return carTypeServices.getCarTypeById(carTypeId);
    }
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public CarType insertCartype(@RequestBody CarType carType){
        return  carTypeServices.insertCarType(carType);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CarType updateCarType(@RequestBody CarType carType){
        return  carTypeServices.updateCartype(carType);
    }

    @DeleteMapping("/delete({id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCarType(@PathVariable("id") Integer carTypeId){
        return carTypeServices.deleteCarType(carTypeId);
    }


}
