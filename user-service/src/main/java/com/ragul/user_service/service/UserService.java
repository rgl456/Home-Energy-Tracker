package com.ragul.user_service.service;

import com.ragul.user_service.dto.UserRequestDto;
import com.ragul.user_service.dto.UserResponseDto;
import com.ragul.user_service.entity.User;
import com.ragul.user_service.mapper.UserMapper;
import com.ragul.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


}
