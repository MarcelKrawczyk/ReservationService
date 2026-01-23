package com.example.reservationService.service;

import com.example.reservationService.model.ServiceOffering;
import com.example.reservationService.repository.ServiceOfferingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    public ServiceOfferingService(ServiceOfferingRepository ServiceOfferingRepository) {
        this.serviceOfferingRepository = ServiceOfferingRepository;
    }

    public ServiceOffering create(ServiceOffering service) {
        return serviceOfferingRepository.save(service);
    }

    public List<ServiceOffering> getAll() {
        return serviceOfferingRepository.findAll();
    }
}

