package com.example.reservationService.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;

    private LocalDateTime reservationTime = LocalDateTime.now();
    public enum Status {
        PENDING,
        FULFILLED,
        CANCELED
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    protected Reservation() {}

    public Reservation(Long id, User client, ServiceOffering serviceOffering,
                       LocalDateTime reservationTime, Status status) {
        this.id = id;
        this.client = client;
        this.serviceOffering = serviceOffering;
        this.reservationTime = reservationTime;
        this.status = status;
    }
    @Transient
    public String getDisplayId() {
        return "R" + id;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getClient() { return client; }
    public void setClient(User client) { this.client = client; }

    public ServiceOffering getServiceOffering() { return serviceOffering; }
    public void setServiceOffering(ServiceOffering serviceOffering) { this.serviceOffering = serviceOffering; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
