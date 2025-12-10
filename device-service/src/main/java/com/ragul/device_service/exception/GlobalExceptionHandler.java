package com.ragul.device_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<String> handleDeviceNotFoundException(DeviceNotFoundException deviceNotFoundException){
        return new ResponseEntity(deviceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
