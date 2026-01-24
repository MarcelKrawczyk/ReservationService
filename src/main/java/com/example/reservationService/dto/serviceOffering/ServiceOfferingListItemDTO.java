package com.example.reservationService.dto.serviceOffering;

import java.math.BigDecimal;

public record ServiceOfferingListItemDTO(
        String name,
        BigDecimal price
) {}
