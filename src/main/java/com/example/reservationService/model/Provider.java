package com.example.reservationService.model;

import jakarta.persistence.*;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public Provider() {}

    public Provider(String name, String description) {
        this.name = name;
        this.description = description;
    }
    // getters and setters
}

