package com.example.reservationService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SERVICEOFFERINGS")
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String describtion;

    private double price;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private User provider;

    private boolean isReserved = false;

    protected ServiceOffering() {}

    public ServiceOffering(Long id, String name, String describtion, double price,
                           User provider, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.describtion = describtion;
        this.price = price;
        this.provider = provider;
        this.isReserved = isReserved;
    }

    @Transient
    public String getDisplayId() {
        return "S" + id;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescribtion() { return describtion; }
    public void setDescribtion(String describtion) { this.describtion = describtion; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public User getProvider() { return provider; }
    public void setProvider(User provider) {
        this.provider = provider;
    }
    public boolean getIsReserved() { return isReserved; }
    public void setIsReserved(boolean isReserved) { this.isReserved = isReserved; }
}
