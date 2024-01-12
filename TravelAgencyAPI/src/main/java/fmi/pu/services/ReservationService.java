package fmi.pu.services;

import fmi.pu.models.DTOs.ReservationDTO;
import fmi.pu.models.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(ReservationDTO reservation);

    Reservation findReservationById(int id);

    List<Reservation> findAllReservations();

    Reservation editReservation(int id, ReservationDTO reservation);

    void deleteReservation(int id);
}
