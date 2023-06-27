package com.jairo.renta_car.services;

import com.jairo.renta_car.models.Reservation;
import com.jairo.renta_car.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.getAll();
    }

    public List<Reservation> getAllReservationsByDates(String start_date,String end_data){
        if(start_date.compareTo(end_data)>0) // Validate endData is not previous to startDate
            return null;
        return  reservationRepository.getAllByDates(start_date,end_data);
    }
    public Optional<Reservation> getReservationById(Integer reservationId){
        if (reservationId<0)
            return null;
        return reservationRepository.getById(reservationId);
    }
    public Reservation insertReservation(Reservation reservation){
        if ((reservation.getCarFK()!= null) && (reservation.getClientFK())!=null ){
            if ((reservation.getStartDate()!=null) && (reservation.getEndDate()!=null)
            && reservation.getEndDate().compareTo(reservation.getStartDate())>0){
                if (reservation.getCost()!=null)
                    return reservationRepository.save(reservation);
                else
                    return reservation;
            }

            else
                return reservation;
        }
        else {
            return reservation;
        }
    }

    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation>temp = getReservationById(reservation.getIdReservation());
            if (temp.isPresent()){
                if (reservation.getCost()!=null)
                    temp.get().setCost(reservation.getCost());
                if (reservation.getGrade()!=null)
                    temp.get().setGrade(reservation.getGrade());
                if (reservation.getComment()!=null)
                    temp.get().setComment(reservation.getComment());
                if (reservation.getEndDate()!=null){
                    if (reservation.getEndDate().compareTo(temp.get().getStartDate())>0)
                        temp.get().setEndDate(reservation.getEndDate());
                }
                return reservationRepository.save(temp.get());
            }
            else
                return reservation;
        }
        else
            return reservation;

    }
    public boolean deleteReservation(Integer reservationId){
    Boolean success = getReservationById(reservationId).map(reservation -> {
        reservationRepository.delete(reservation);
        return true;
    }).orElse(false);
    return success;
    }
}
