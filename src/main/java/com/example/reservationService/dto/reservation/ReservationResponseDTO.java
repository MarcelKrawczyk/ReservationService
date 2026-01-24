package com.example.reservationService.dto.reservation;

import java.time.LocalDateTime;

public record ReservationResponseDTO(
        Long id,
        LocalDateTime reservationTime,
        Long userId,
        Long providerId,
        Long serviceOfferingId
) {}