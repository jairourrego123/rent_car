package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired // conecta la interfaz con el repositoio
    private CarCRUDRepository carCRUDRepository;

    /**
     * This method return a list of all cars
     * @return car's list
     */
    public List<Car> getAll(){
        return (List<Car>) carCRUDRepository.findAll(); //Trae todos los carros y los convierte a un tipo de dato especifico

    }

    /**
     * This method return a list of cars based on the year
     * @param year
     * @return car's list
     */
    public  List<Car> getAllByYear(Integer year){
        return carCRUDRepository.findByYear(year);
    }
    public Optional<Car> getById(Integer carId){
        return  carCRUDRepository.findById(carId);

    }

    public  Optional<Car> getByPlate(String plate){
        return carCRUDRepository.findByPlate(plate);
    }

    public Car save(Car car){
        return  carCRUDRepository.save(car);

    }

    public void delete(Car car){ // void por que no retorna nada
        carCRUDRepository.delete(car);
    }
}
