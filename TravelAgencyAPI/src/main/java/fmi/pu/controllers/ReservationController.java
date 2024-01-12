package fmi.pu.controllers;

import fmi.pu.models.DTOs.ReservationDTO;
import fmi.pu.models.Reservation;
import fmi.pu.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel-agency/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @PutMapping
    public ResponseEntity<Reservation> editReservation(@RequestBody ReservationDTO reservation) {
        return ResponseEntity.ok(reservationService.editReservation(reservation.getId(), reservation));
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReservation(int id) {
        reservationService.deleteReservation(id);
    }
}
