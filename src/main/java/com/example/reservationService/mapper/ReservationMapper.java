package com.example.reservationService.mapper;

import com.example.reservationService.dto.provider.ProviderListItemDTO;
import com.example.reservationService.dto.reservation.ReservationCreateDTO;
import com.example.reservationService.dto.reservation.ReservationResponseDTO;
import com.example.reservationService.dto.serviceOffering.ServiceOfferingListItemDTO;
import com.example.reservationService.dto.user.UserListItemDTO;
import com.example.reservationService.model.Provider;
import com.example.reservationService.model.Reservation;
import com.example.reservationService.model.ServiceOffering;
import com.example.reservationService.model.User;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation toEntity(ReservationCreateDTO dto, User user, Provider provider, ServiceOffering offering) {
        Reservation reservation = new Reservation();
        reservation.setReservationTime(dto.reservationTime());
        reservation.setUser(user);
        reservation.setProvider(provider);
        reservation.setServiceOffering(offering);
        return reservation;
    }

    public ReservationResponseDTO toResponseDTO(Reservation reservation) {
        return new ReservationResponseDTO(
                reservation.getId(),
                reservation.getReservationTime(),
                new UserListItemDTO(
                        reservation.getUser().getId(),
                        reservation.getUser().getName()
                ),
                new ProviderListItemDTO(
                        reservation.getProvider().getId(),
                        reservation.getProvider().getName()
                ),
                new ServiceOfferingListItemDTO(
                        reservation.getServiceOffering().getId(),
                        reservation.getServiceOffering().getName(),
                        reservation.getServiceOffering().getDurationMinutes()
                )
        );
    }
}
