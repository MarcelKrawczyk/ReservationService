package com.example.reservationService.service;

import com.example.reservationService.model.Provider;
import com.example.reservationService.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAll() {
        return providerRepository.findAll();
    }

    public Provider getById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    public Provider update(Long id, Provider provider) {
        Provider existing = getById(id);
        existing.setName(provider.getName());
        existing.setAddress(provider.getAddress());
        return providerRepository.save(existing);
    }

    public void delete(Long id) {
        providerRepository.deleteById(id);
    }
}
