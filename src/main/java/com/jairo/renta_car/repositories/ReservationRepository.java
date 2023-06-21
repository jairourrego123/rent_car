package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    private List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }
    private Optional<Reservation> getById(Integer reservationId){
        return reservationCRUDRepository.findById(reservationId);
    }
    private Reservation save(Reservation reservation){
        return reservationCRUDRepository.save(reservation);

    }
    private void delete (Reservation reservation){
        reservationCRUDRepository.delete(reservation);

    }
}
