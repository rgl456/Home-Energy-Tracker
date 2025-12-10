package com.ragul.user_service.service;

import com.ragul.user_service.dto.UserRequestDto;
import com.ragul.user_service.dto.UserResponseDto;
import com.ragul.user_service.entity.User;
import com.ragul.user_service.mapper.UserMapper;
import com.ragul.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        User createdUser = UserMapper.dtoToEntity(requestDto);

        userRepository.save(createdUser);

        return UserMapper.entityToDto(createdUser);
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id "+ id));

        return UserMapper.entityToDto(user);
    }

    public UserResponseDto updateUserById(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id "+ id));

        user.setFirstName(requestDto.firstName());
        user.setLastName(requestDto.lastName());
        user.setEmail(requestDto.email());
        user.setAddress(requestDto.address());
        user.setAlerting(requestDto.alerting());
        user.setEnergyAlertingThreshold(requestDto.energyAlertingThreshold());
        User savedUser = userRepository.save(user);

        return UserMapper.entityToDto(savedUser);
    }

    public String deleteUserById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id "+ id));

        userRepository.deleteById(id);

        return "User deleted successfully id " + id;
    }

}
