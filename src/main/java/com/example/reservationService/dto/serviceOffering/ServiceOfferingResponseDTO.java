package com.example.reservationService.dto.serviceOffering;

import java.math.BigDecimal;

public record ServiceOfferingResponseDTO(
        String name,
        Long id,
        BigDecimal price
) {}
