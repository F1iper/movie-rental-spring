package com.movierental.spring.application.controllers.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
