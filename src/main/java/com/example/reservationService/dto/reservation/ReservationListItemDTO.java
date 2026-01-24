package com.example.reservationService.dto.reservation;
import java.time.LocalDateTime;
public record ReservationListItemDTO(
        Long id,
        LocalDateTime reservationTime,
        String userName,
        String providerName
) {}