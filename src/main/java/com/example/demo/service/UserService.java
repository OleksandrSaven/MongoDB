package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.dto.UserResponseDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDto register(UserRegistrationDto userDto);

    @Cacheable(value = "specification")
    UserResponseDto getUser(String email);
}
