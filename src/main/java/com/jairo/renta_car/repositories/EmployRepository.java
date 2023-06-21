package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployRepository {
    @Autowired
    private EmployCRUDRepository employCRUDRepository;

    private List<Employ> getAll(){
        return (List<Employ>) employCRUDRepository.findAll();
    }
    private Optional<Employ> getById(Integer employId){
        return employCRUDRepository.findById(employId);
    }
    private Employ salve(Employ employ){
        return employCRUDRepository.save(employ);
    }
    private void delete(Employ employ){
        employCRUDRepository.delete(employ);
    }
}
