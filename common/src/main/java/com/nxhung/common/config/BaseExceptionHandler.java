package com.nxhung.common.config;

import com.nxhung.common.dtos.BaseResponseDto;
import com.nxhung.common.dtos.NoResponseDto;
import com.nxhung.common.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<BaseResponseDto<NoResponseDto>> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        var response = BaseResponseDto.<NoResponseDto>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return response.toResponseEntity();
    }
}
