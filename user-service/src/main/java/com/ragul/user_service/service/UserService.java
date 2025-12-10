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
        log.info("User created successfully : {}", createdUser);

        userRepository.save(createdUser);

        return UserMapper.entityToDto(createdUser);
    }


    public UserResponseDto getUserById(Long id) {
        log.info("Getting user by id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found With this Id = "+ id));
        log.info("user fetched successfully {}", user);
        return UserMapper.entityToDto(user);
    }

}
