package com.ragul.device_service.mapper;

import com.ragul.device_service.dto.DeviceRequestDto;
import com.ragul.device_service.dto.DeviceResponseDto;
import com.ragul.device_service.entity.Device;

public class DeviceMapper {

    public static DeviceResponseDto entityToDto(Device device){
        return new DeviceResponseDto(
                device.getId(),
                device.getName(),
                device.getType(),
                device.getLocation(),
                device.getUserId()
        );
    }


    public static Device dtoToEntity(DeviceRequestDto requestDto) {
        final Device device = Device.builder()
                .name(requestDto.name())
                .type(requestDto.type())
                .location(requestDto.location())
                .userId(requestDto.userId())
                .build();
        return device;
    }
}
