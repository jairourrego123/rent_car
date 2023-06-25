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

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    public List<Reservation>  getAllByDates(String start_data,String end_data){
        return reservationCRUDRepository.findReservationByDates(start_data,end_data);
    }
    public Optional<Reservation> getById(Integer reservationId){
        return reservationCRUDRepository.findById(reservationId);
    }
    public Reservation save(Reservation reservation){
        return reservationCRUDRepository.save(reservation);

    }
    public void delete (Reservation reservation){
        reservationCRUDRepository.delete(reservation);

    }
}
