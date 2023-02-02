package com.movierental.spring.application.controllers.auth;

import com.movierental.spring.configuration.JwtUtil;
import com.movierental.spring.configuration.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtTokenUtil;


    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(request.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
