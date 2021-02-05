package com.kusumotolab.springstarter.services;

import com.kusumotolab.springstarter.dto.CreateUserDto;

public interface UserService {
    void saveUser(CreateUserDto createUserDto);
}
