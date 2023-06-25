package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Employ;
import com.jairo.renta_car.repositories.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployServices {

    @Autowired
    private EmployRepository employRepository;

    public List<Employ> getAllEmployees(){
        return employRepository.getAll();
    }

    public Optional<Employ> getEmployeesById(Integer employId){
        return employRepository.getById(employId);
    }
    public Employ insertEmployees (Employ employ){

    }
    public  Employ updateEmployees(Employ employ){

    }
    public boolean deleteEmploy(Integer employId){
        Boolean success= getEmployeesById(employId).map(employ -> {
            employRepository.delete(employ);
            return true;
        }).orElse(false);
        return success;

    }
}
