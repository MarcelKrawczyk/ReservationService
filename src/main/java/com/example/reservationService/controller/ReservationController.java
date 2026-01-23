package com.example.reservationService.controller;

import com.example.reservationService.model.Reservation;
import com.example.reservationService.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation created = reservationService.create(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Reservation>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(reservationService.getByClientId(clientId));
    }
    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Reservation>> getByProvider(@PathVariable Long providerId) {
        return ResponseEntity.ok(reservationService.getByProviderId(providerId));
    }
}


