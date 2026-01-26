package com.example.reservationService.service;

import com.example.reservationService.dto.serviceOffering.ServiceOfferingCreateDTO;
import com.example.reservationService.dto.serviceOffering.ServiceOfferingListItemDTO;
import com.example.reservationService.dto.serviceOffering.ServiceOfferingResponseDTO;
import com.example.reservationService.exception.NotFoundException;
import com.example.reservationService.model.Provider;
import com.example.reservationService.model.ServiceOffering;
import com.example.reservationService.repository.ProviderRepository;
import com.example.reservationService.repository.ServiceOfferingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferingService {

    private final ServiceOfferingRepository repository;
    private final ProviderRepository providerRepository;

    public ServiceOfferingService(ServiceOfferingRepository repository,
                                  ProviderRepository providerRepository) {
        this.repository = repository;
        this.providerRepository = providerRepository;
    }

    public ServiceOfferingResponseDTO create(ServiceOfferingCreateDTO dto) {

        Provider provider = providerRepository.findById(dto.providerId())
                .orElseThrow(() -> new NotFoundException("Provider with id " + dto.providerId() + " not found"));

        ServiceOffering offering = ServiceOffering.builder()
                .serviceName(dto.name())
                .price(dto.price())
                .provider(provider)
                .build();

        repository.save(offering);

        return mapToResponseDTO(offering);
    }

    public List<ServiceOfferingListItemDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToListItemDTO)
                .toList();
    }

    public ServiceOfferingResponseDTO getById(Long id) {
        ServiceOffering offering = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Service offering with id " + id + " not found"));

        return mapToResponseDTO(offering);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Service offering with id " + id + " not found");
        }
        repository.deleteById(id);
    }

    private ServiceOfferingResponseDTO mapToResponseDTO(ServiceOffering offering) {
        return new ServiceOfferingResponseDTO(
                offering.getServiceName(),
                offering.getId(),
                offering.getPrice()
        );
    }

    private ServiceOfferingListItemDTO mapToListItemDTO(ServiceOffering offering) {
        return new ServiceOfferingListItemDTO(
                offering.getServiceName(),
                offering.getPrice()
        );
    }
}
