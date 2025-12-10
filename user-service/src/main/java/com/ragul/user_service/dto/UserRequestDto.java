package com.ragul.user_service.dto;

public record UserRequestDto(
        String firstName,
        String lastName,
        String email,
        String address,
        boolean alerting,
        double energyAlertingThreshold
) {
}
