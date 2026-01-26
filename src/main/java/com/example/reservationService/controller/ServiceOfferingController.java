package com.example.reservationService.controller;

import com.example.reservationService.dto.serviceOffering.ServiceOfferingCreateDTO;
import com.example.reservationService.dto.serviceOffering.ServiceOfferingListItemDTO;
import com.example.reservationService.dto.serviceOffering.ServiceOfferingResponseDTO;
import com.example.reservationService.service.ServiceOfferingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-offerings")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    public ServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }

    @PostMapping
    public ResponseEntity<ServiceOfferingResponseDTO> create(@RequestBody ServiceOfferingCreateDTO dto) {
        ServiceOfferingResponseDTO created = serviceOfferingService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<ServiceOfferingListItemDTO>> getAll() {
        return ResponseEntity.ok(serviceOfferingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOfferingResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceOfferingService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceOfferingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
