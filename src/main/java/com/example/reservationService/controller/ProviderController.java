package com.example.reservationService.controller;

import com.example.reservationService.model.Provider;
import com.example.reservationService.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider created = providerService.create(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        return ResponseEntity.ok(providerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id, @RequestBody Provider provider) {
        return ResponseEntity.ok(providerService.update(id, provider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
