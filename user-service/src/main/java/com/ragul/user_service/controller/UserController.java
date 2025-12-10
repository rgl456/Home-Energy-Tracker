package com.ragul.user_service.controller;

import com.ragul.user_service.dto.UserRequestDto;
import com.ragul.user_service.dto.UserResponseDto;
import com.ragul.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        return new ResponseEntity<>(userService.createUser(requestDto), HttpStatus.CREATED);
    }



}
