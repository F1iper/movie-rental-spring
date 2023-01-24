package com.movierental.spring.application.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
