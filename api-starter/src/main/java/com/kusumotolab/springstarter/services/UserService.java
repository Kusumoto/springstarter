package com.kusumotolab.springstarter.services;

import com.kusumotolab.springstarter.dto.CreateUserDto;
import com.kusumotolab.springstarter.entities.User;
import org.springframework.stereotype.Service;

public interface UserService {
    void saveUser(CreateUserDto createUserDto);
}
