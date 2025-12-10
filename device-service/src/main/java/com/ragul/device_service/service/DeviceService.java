package com.ragul.device_service.service;

import com.ragul.device_service.dto.DeviceRequestDto;
import com.ragul.device_service.dto.DeviceResponseDto;
import com.ragul.device_service.entity.Device;
import com.ragul.device_service.mapper.DeviceMapper;
import com.ragul.device_service.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceResponseDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Device not with this id "+id));
        DeviceResponseDto responseDto = DeviceMapper.entityToDto(device);
        return responseDto;
    }

    public DeviceResponseDto createDevice(DeviceRequestDto requestDto) {
        Device device = DeviceMapper.dtoToEntity(requestDto);
        deviceRepository.save(device);
        return DeviceMapper.entityToDto(device);
    }

    public DeviceResponseDto updateUserById(Long id, DeviceRequestDto requestDto) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not with this id "+id));
        device.setName(requestDto.name());
        device.setType(requestDto.type());
        device.setLocation(requestDto.location());
        device.setUserId(requestDto.userId());
        Device savedDevice = deviceRepository.save(device);
        return DeviceMapper.entityToDto(savedDevice);
    }

    public String deleteUserById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not with this id "+id));
        deviceRepository.deleteById(id);
        return "device deleted successfully! id " + id;
    }

}
