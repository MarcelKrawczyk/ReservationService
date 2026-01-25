package com.example.reservationService.service;

import com.example.reservationService.dto.user.UserCreateDTO;
import com.example.reservationService.dto.user.UserListItemDTO;
import com.example.reservationService.dto.user.UserResponseDTO;
import com.example.reservationService.model.User;
import com.example.reservationService.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.reservationService.exception.NotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponseDTO createUser(UserCreateDTO dto) {
        User user = User.builder()
                .fullName(dto.name())
                .email(dto.email())
                .phoneNumber(dto.phoneNumber())
                .build();

        userRepository.save(user);

        return mapToResponseDTO(user);
    }
    public List<UserListItemDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToListItemDTO)
                .toList();
    }
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));

        return mapToResponseDTO(user);
    }
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }
    private UserResponseDTO mapToResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
    private UserListItemDTO mapToListItemDTO(User user) {
        return new UserListItemDTO(
                user.getFullName(),
                user.getId(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
