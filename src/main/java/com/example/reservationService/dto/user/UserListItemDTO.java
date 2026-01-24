package com.example.reservationService.dto.user;

public record UserListItemDTO(
        String name,
        Long id,
        String email,
        String phoneNumber
) {}
