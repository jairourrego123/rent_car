package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.PQR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PqrRepository {
    @Autowired
    private PqrCRUDRepository pqrCRUDRepository;

    private List<PQR> getAll(){
        return (List<PQR>) pqrCRUDRepository.findAll();
    }
    private Optional<PQR> getById(Integer pqrId){
        return pqrCRUDRepository.findById(pqrId);
    }
    private PQR save(PQR pqr){
        return pqrCRUDRepository.save(pqr);
    }
    private void delete(PQR pqr){
        pqrCRUDRepository.delete(pqr);
    }
}
