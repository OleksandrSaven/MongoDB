package com.example.demo.controller;

import com.example.demo.dto.UserLoginRequestDto;
import com.example.demo.dto.UserLoginResponseDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.security.AuthenticationService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody UserRegistrationDto requestDto) {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authentication(requestDto);
    }

    @GetMapping("/user")
    public UserResponseDto findUser(@RequestParam String email) {
        return userService.getUser(email);
    }
}

