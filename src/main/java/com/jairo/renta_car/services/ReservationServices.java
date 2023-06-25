package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Reservation;
import com.jairo.renta_car.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.getAll();
    }

    public List<Reservation> getAllReservationsByDates(String start_date,String end_data){
        if(start_date.compareTo(end_data)<0) // Validate endData is not previous to startDate
            return null;
        return  reservationRepository.getAllByDates(start_date,end_data);
    }
    public Optional<Reservation> getReservationById(Integer reservationId){
        if (reservationId<0)
            return null;
        return reservationRepository.getById(reservationId);
    }
    public Reservation insertReservation(Reservation reservation){

    }

    public Reservation updateReservation(Reservation reservation){

    }
    public boolean deleteReservation(Integer reservationId){
    Boolean success = getReservationById(reservationId).map(reservation -> {
        reservationRepository.delete(reservation);
        return true;
    }).orElse(false);
    return success;
    }
}
