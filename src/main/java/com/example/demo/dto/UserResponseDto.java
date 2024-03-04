package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Setter;

import java.util.Set;

@Setter
public class UserResponseDto {
    public String email;
    public Set<User.RoleName> roleName;
}
