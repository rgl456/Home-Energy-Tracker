package com.ragul.device_service.dto;

import com.ragul.device_service.model.DeviceType;

public record DeviceRequestDto(
        String name,
        DeviceType type,
        String location,
        Long userId
) {
}
