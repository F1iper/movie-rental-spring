package com.movierental.spring.application.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDto {

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String username;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 8, message = "must contain more than 8 characters")
    private String password;
}
