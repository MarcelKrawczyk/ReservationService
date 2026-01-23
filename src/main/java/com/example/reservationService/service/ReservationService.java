package com.example.reservationService.service;

import com.example.reservationService.model.Reservation;
import com.example.reservationService.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<Reservation> getByClientId(Long clientId) {
        return reservationRepository.findByClientId(clientId);
    }

    public List<Reservation> getByProviderId(Long providerId) {
        return reservationRepository.findByServiceOfferingProviderId(providerId);
    }
}
