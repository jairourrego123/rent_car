package com.jairo.renta_car.repositories;

import com.jairo.renta_car.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationCRUDRepository extends CrudRepository<Reservation,Integer> {
    @Query(value = "SELECT * FROM reservations WHERE start_date >= ? and end_Date <= ?;",nativeQuery = true)
    public List<Reservation> findReservationByDatesAndStatus(String s_date,String e_date);
}
