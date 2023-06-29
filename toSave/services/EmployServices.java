package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Employ;
import com.jairo.renta_car.repositories.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
        if (employ.getName()!=null)
            return employRepository.salve(employ);
        else
            return employ;
    }
    public  Employ updateEmployees(Employ employ){
        if (employ.getIdEmployed()!=null){
            Optional<Employ> temp = getEmployeesById(employ.getIdEmployed());
            if (temp.isPresent()){
                if (employ.getIsAdmin()!=null)
                    temp.get().setIsAdmin(employ.getIsAdmin());
                if (employ.getName()!=null)
                    temp.get().setName(employ.getName());
                return employRepository.salve(temp.get());

            }
            else
                return employ;
        }
        else
            return employ;
    }
    public boolean deleteEmploy(Integer employId){
        Boolean success= getEmployeesById(employId).map(employ -> {
            employRepository.delete(employ);
            return true;
        }).orElse(false);
        return success;

    }
}
