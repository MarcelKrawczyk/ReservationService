package com.example.reservationService.dto.user;
public record UserCreateDTO(
        String fullName,
        String email,
        String phoneNumber
) {}