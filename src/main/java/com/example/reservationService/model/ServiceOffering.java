package com.example.reservationService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "service_offerings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String serviceName;

    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "serviceOffering", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceOffering)) return false;
        return id != null && id.equals(((ServiceOffering) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}