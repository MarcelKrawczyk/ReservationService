package com.example.reservationService.controller;

import com.example.reservationService.model.ServiceOffering;
import com.example.reservationService.service.ServiceOfferingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    public ServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }
    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceOffering service) {
        ServiceOffering created = serviceOfferingService.create(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public ResponseEntity<List<ServiceOffering>> getAllServices() {
        return ResponseEntity.ok(serviceOfferingService.getAll());
    }
}
