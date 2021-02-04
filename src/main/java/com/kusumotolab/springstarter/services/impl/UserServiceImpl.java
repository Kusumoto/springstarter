package com.kusumotolab.springstarter.services.impl;

import com.kusumotolab.springstarter.dto.CreateUserDto;
import com.kusumotolab.springstarter.entities.User;
import com.kusumotolab.springstarter.mapper.UserMapper;
import com.kusumotolab.springstarter.repositories.UserRepository;
import com.kusumotolab.springstarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserDto createUserDto) {
        createUserDto.setEncryptPassword(passwordEncoder.encode(createUserDto.getPassword()));
        User user = UserMapper.createUserDtoToUserMapper(createUserDto);
        userRepository.save(user);
    }
}
