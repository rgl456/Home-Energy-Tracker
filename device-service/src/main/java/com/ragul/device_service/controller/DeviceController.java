package com.ragul.device_service.controller;

import com.ragul.device_service.dto.DeviceRequestDto;
import com.ragul.device_service.dto.DeviceResponseDto;
import com.ragul.device_service.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponseDto> getDeviceById(@PathVariable Long id){
        return new ResponseEntity<>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeviceResponseDto> createDevice(@RequestBody DeviceRequestDto requestDto){
        return new ResponseEntity<>(deviceService.createDevice(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponseDto> updateUserById(@PathVariable Long id, @RequestBody DeviceRequestDto requestDto){
        return new ResponseEntity<>(deviceService.updateUserById(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return new ResponseEntity<>(deviceService.deleteUserById(id), HttpStatus.OK);
    }

}
