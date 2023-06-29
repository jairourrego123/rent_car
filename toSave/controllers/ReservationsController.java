package com.jairo.renta_car.controllers;

import com.jairo.renta_car.models.Reservation;
import com.jairo.renta_car.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired
    private ReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> getAllReservation(){
        return reservationServices.getAllReservations();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Reservation> getReservationById(@PathVariable("id") Integer reservationId){
        return reservationServices.getReservationById(reservationId);
    }

    @GetMapping("/all/{start_date}/{end_date}")
    public List<Reservation> getAllReservationByDates(@PathVariable("start_date") String start_date,
                                                      @PathVariable("enda_date") String end_date){
        return  reservationServices.getAllReservationsByDates(start_date,end_date);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
     public Reservation insertReservation(@RequestBody Reservation reservation){
        return reservationServices.insertReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationServices.updateReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteReservation (@PathVariable("id") Integer reservationId){
        return reservationServices.deleteReservation(reservationId);
    }

}
