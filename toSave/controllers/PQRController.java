package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.PQR;
import com.jairo.renta_car.services.PqrServices;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pqrs")
public class PQRController {

    @Autowired
    private PqrServices pqrServices;
    @GetMapping("/all")
    public List<PQR> getAllPQRs(){
        return pqrServices.getAllPQRs();
    }
    @GetMapping("/by_id/{id}")
    public Optional<PQR> getPQRById(@PathVariable("id") Integer pqrId){
        return pqrServices.getPQRById(pqrId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public PQR insertPqr(@RequestBody PQR pqr){
        return  pqrServices.insertPqr(pqr);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public PQR updatePqr(@RequestBody PQR pqr){
        return pqrServices.updatePqr(pqr);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deletePqr(@PathVariable("id")Integer pqrId){
        return  pqrServices.deletePqr(pqrId);
    }
}
