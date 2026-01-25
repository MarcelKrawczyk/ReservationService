package com.example.reservationService.dto.user;
public record UserCreateDTO(
        String name,
        String email,
        String phoneNumber
) {}