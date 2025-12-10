package com.ragul.user_service.service;

import com.ragul.user_service.dto.UserRequestDto;
import com.ragul.user_service.dto.UserResponseDto;
import com.ragul.user_service.entity.User;
import com.ragul.user_service.mapper.UserMapper;
import com.ragul.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        log.info("Creating user : {}", requestDto);
        User createdUser = UserMapper.dtoToEntity(requestDto);

        userRepository.save(createdUser);
        log.info("User created successfully : {}", createdUser);

        return UserMapper.entityToDto(createdUser);
    }


    public UserResponseDto getUserById(Long id) {
        log.info("Getting user by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id = "+ id));

        log.info("user fetched successfully {}", user);
        return UserMapper.entityToDto(user);
    }

    public UserResponseDto updateUserById(Long id, UserRequestDto requestDto) {
        log.info("Getting user by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id = "+ id));

        user.setFirstName(requestDto.firstName());
        user.setLastName(requestDto.lastName());
        user.setEmail(requestDto.email());
        user.setAddress(requestDto.address());
        user.setAlerting(requestDto.alerting());
        user.setEnergyAlertingThreshold(requestDto.energyAlertingThreshold());
        User savedUser = userRepository.save(user);

        log.info("User updated successfully : {}", savedUser);
        return UserMapper.entityToDto(savedUser);
    }
}
