package com.example.demo.exaption;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(LocalDateTime timestamp,
                               HttpStatus status,
                               String[] errors){
}
