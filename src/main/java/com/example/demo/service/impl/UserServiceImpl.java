package com.example.demo.service.impl;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exaption.RegistrationException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()) != null) {
            throw  new RegistrationException("Can't find user by email: "
                    + userDto.getEmail());
        }
        User user = userMapper.toModel(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User.RoleName roleAdmin = User.RoleName.ROLE_ADMIN;
        User.RoleName roleUser = User.RoleName.ROLE_USER;
        user.setRoleName(new HashSet<>(Set.of(roleAdmin, roleUser)));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto getUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new RuntimeException("User does not exist in the database");
        }
        return userMapper.toDto(user);
    }
}
