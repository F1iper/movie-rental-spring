package com.movierental.spring.application.controllers.auth;

import com.movierental.spring.application.dtos.AppUserDto;
import com.movierental.spring.application.dtos.AuthResponseDto;
import com.movierental.spring.application.dtos.LoginDto;
import com.movierental.spring.application.dtos.RegisterDto;
import com.movierental.spring.application.services.RegisterService;
import com.movierental.spring.configuration.token.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final RegisterService registerService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<AppUserDto> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(registerService.register(registerDto), HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid LoginDto loginDto) {
        return new ResponseEntity<>(new AuthResponseDto(registerService.login(loginDto).getAccessToken()), HttpStatus.OK);
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        log.debug("Token requested for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted {}", token);
        return token;
    }

}
