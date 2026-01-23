package com.example.reservationService.repository;

import com.example.reservationService.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByClientId(Long clientId);

    List<Reservation> findByServiceOfferingProviderId(Long providerId);
}

