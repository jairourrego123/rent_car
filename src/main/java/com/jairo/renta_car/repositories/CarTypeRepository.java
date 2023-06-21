package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Repository
public class CarTypeRepository {

    @Autowired
    private CarTypeCRUDRepository carTypeCRUDRepository;

    public List<CarType> getAll(){
        return  (List<CarType>) carTypeCRUDRepository.findAll();

    }
    public Optional<CarType> getById(Integer carTypeId){
        return carTypeCRUDRepository.findById(carTypeId);

    }
    public CarType save (CarType carType){
        return  carTypeCRUDRepository.save(carType);

    }

    public  void delete (CarType carType){
        carTypeCRUDRepository.delete(carType);
    }

}
