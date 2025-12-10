package com.ragul.user_service.mapper;

import com.ragul.user_service.dto.UserRequestDto;
import com.ragul.user_service.dto.UserResponseDto;
import com.ragul.user_service.entity.User;

public class UserMapper {

    public static User dtoToEntity(UserRequestDto requestDto){
        final User createdUser = User.builder()
                .firstName(requestDto.firstName())
                .lastName(requestDto.lastName())
                .email(requestDto.email())
                .address(requestDto.address())
                .alerting(requestDto.alerting())
                .energyAlertingThreshold(requestDto.energyAlertingThreshold())
                .build();
        return createdUser;
    }

    public static UserResponseDto entityToDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.isAlerting(),
                user.getEnergyAlertingThreshold()
        );
    }

}
