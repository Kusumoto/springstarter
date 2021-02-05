package com.kusumotolab.springstarter.controllers;

import com.kusumotolab.springstarter.dto.CreateUserDto;
import com.kusumotolab.springstarter.models.FieldValidateModel;
import com.kusumotolab.springstarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@Valid @RequestBody CreateUserDto user) {
        userService.saveUser(user);
       return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldValidateModel> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<FieldValidateModel> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            FieldValidateModel errorData = new FieldValidateModel();
            errorData.setFieldName(((FieldError) error).getField());
            errorData.setMessage( error.getDefaultMessage());
            errors.add(errorData);
        });
        return errors;
    }
}
