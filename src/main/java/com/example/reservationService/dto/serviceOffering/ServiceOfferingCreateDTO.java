package com.example.reservationService.dto.serviceOffering;
import java.math.BigDecimal;

public record ServiceOfferingCreateDTO(
        String name,
        BigDecimal price,
        Long providerId
) {}
