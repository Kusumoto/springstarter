package com.kusumotolab.springstarter.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateUserDto {
    @Getter
    @Setter
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Getter
    @Setter
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Getter
    @Setter
    @NotBlank(message = "Confirm password is mandatory")
    private String confirmPassword;

    @Setter
    @Getter
    private String EncryptPassword;
}

