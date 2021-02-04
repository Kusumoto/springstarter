package com.kusumotolab.springstarter.mapper;

import com.kusumotolab.springstarter.dto.CreateUserDto;
import com.kusumotolab.springstarter.entities.User;


public  class UserMapper {
    public static User createUserDtoToUserMapper(CreateUserDto createUserDto) {
        User user = new User();
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getEncryptPassword());
        return user;
    }
}
