package com.movierental.spring.application.controllers.auth;

import com.movierental.spring.configuration.token.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final TokenService tokenService;

    @GetMapping
    public String getMe(Principal principal) {
        return principal.getName();
    }


    @PostMapping("/token")
    public String token(Authentication authentication) {
        log.debug("Token requested for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted {}", token);
        return token;
    }

}
