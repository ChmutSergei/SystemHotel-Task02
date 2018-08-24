package by.chmut.hotel.services;

import by.chmut.hotel.bean.Reservation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation get(Serializable id);

    void update(Reservation reservation);

    int delete(Serializable id);

    List<Reservation> getByUserId(Serializable userId);

    List<Reservation> getByDate(LocalDate startDate, LocalDate endDate);

}
