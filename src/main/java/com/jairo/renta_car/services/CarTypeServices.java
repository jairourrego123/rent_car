package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Car;
import com.jairo.renta_car.models.CarType;
import com.jairo.renta_car.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
        if(carType.getLevel()!=null)
            return carTypeRepository.save(carType);
        else
            return carType;

    }
    public  CarType updateCartype(CarType carType){
        if(carType.getCarTypeId()!=null)
        {
            Optional<CarType> temp = carTypeRepository.getById(carType.getCarTypeId());
            if (temp.isPresent()){
                if (carType.getLevel()!=null)
                    temp.get().setLevel(carType.getLevel());
                if (carType.getLine()!=null)
                    temp.get().setLine(carType.getLine());
                return carTypeRepository.save(temp.get());
            }
            else
                return carType;
        }
        else
            return carType;

    }

    public  boolean deleteCarType(Integer carTypeId){
    Boolean success = getCarTypeById(carTypeId).map(carType -> {
        carTypeRepository.delete(carType);
        return true;
    }).orElse(false);
    return success;
    }

}
