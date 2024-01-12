package fmi.pu.services.implementations;

import fmi.pu.models.DTOs.ReservationDTO;
import fmi.pu.models.Holiday;
import fmi.pu.models.Reservation;
import fmi.pu.repos.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements fmi.pu.services.ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(ReservationDTO reservation) {
        Holiday holiday = new Holiday();
        holiday.setId(reservation.getHoliday());

        Reservation reservationForRepo = Reservation.builder()
                .holiday(holiday)
                .contactName(reservation.getContactName())
                .phoneNumber(reservation.getPhoneNumber())
                .build();

        return reservationRepository.save(reservationForRepo);
    }

    @Override
    public Reservation findReservationById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation editReservation(int id, ReservationDTO reservation) {
        Reservation oldReservation = this.findReservationById(id);

        Holiday holiday = Holiday.builder().id(reservation.getHoliday()).build();

        oldReservation.setHoliday(holiday);
        oldReservation.setContactName(reservation.getContactName());
        oldReservation.setPhoneNumber(reservation.getPhoneNumber());

        return reservationRepository.save(oldReservation);
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
