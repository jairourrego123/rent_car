package com.jairo.renta_car.services;

import com.jairo.renta_car.models.PQR;
import com.jairo.renta_car.repositories.PqrRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

public class PqrServices {

    @Autowired
    private PqrRepository pqrRepository;

    public List<PQR> getAllPQRs(){
        return pqrRepository.getAll();
    }
    public Optional<PQR> getPQRById(Integer pqrId){
        return pqrRepository.getById(pqrId);
    }
    public  PQR insertPqr(PQR pqr){
        if ((pqr.getType()!=null)&&(pqr.getContent()!=null) && (pqr.getClientFK()!=null))
            return pqrRepository.save(pqr);
        else
            return pqr;

    }
    public  PQR updatePqr(PQR pqr){
        if(pqr.getIdPqr()!=null){
            Optional<PQR> temp = getPQRById(pqr.getIdPqr());
            if (temp.isPresent()){
                if (pqr.getContent()!=null)
                    temp.get().setContent(pqr.getContent());
                return pqrRepository.save(temp.get());
            }
            else
                return pqr;
        }
        else
            return pqr;
    }
    public boolean deletePqr(Integer pqrId){
    Boolean success = getPQRById(pqrId).map(pqr -> {
        pqrRepository.delete(pqr);
        return true;
    }).orElse(false);
        return success;
    }
}
