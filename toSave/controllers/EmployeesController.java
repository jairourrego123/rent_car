package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.Employ;
import com.jairo.renta_car.services.EmployServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployServices employServices;
    @GetMapping("/all")
    public List<Employ> getAllEmployees(){
        return employServices.getAllEmployees();
    }
    @GetMapping("/by_id/{id}")
    public Optional<Employ> getEmployeesById(@PathVariable("id") Integer employId){
        return employServices.getEmployeesById(employId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public  Employ insertEmployees(@RequestBody Employ employ){
        return employServices.insertEmployees(employ);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Employ updateEmployees(@RequestBody Employ employ){
        return employServices.updateEmployees(employ);

    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteEmploy(@PathVariable("id") Integer employId){
        return employServices.deleteEmploy(employId);
    }
}
