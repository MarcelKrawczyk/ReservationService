package com.example.reservationService.dto.reservation;
import java.time.LocalDateTime;

public record ReservationCreateDTO(
        Long userId,
        Long providerId,
        Long serviceOfferingId,
        LocalDateTime reservationTime
) {}

