package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.dtos.AppUserDto;
import com.movierental.spring.application.dtos.AuthResponseDto;
import com.movierental.spring.application.dtos.LoginDto;
import com.movierental.spring.application.dtos.RegisterDto;
import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;
import com.movierental.spring.application.mappers.AppUserMapper;
import com.movierental.spring.application.repositories.AppUserRepository;
import com.movierental.spring.application.repositories.RoleRepository;
import com.movierental.spring.application.services.RegisterService;
import com.movierental.spring.configuration.token.TokenService;
import com.movierental.spring.exceptions.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AppUserMapper appUserMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public AppUserDto register(RegisterDto registerDto) {
        if (appUserRepository.existsByUsername(registerDto.getUsername())) {
            throw new UserAlreadyExistsException("User with username " + registerDto.getUsername() + " already exists.");
        }
        if (registerDto.getPassword() == null) {
            throw new IllegalArgumentException("Password is required.");
        }

        AppUser user = new AppUser();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role roles = roleRepository.findByName("ADMIN");
        user.setRoles(Collections.singletonList(roles));
        appUserRepository.save(user);
        return appUserMapper.toDto(user);
    }

    @Override
    public AuthResponseDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenService.generateToken(authentication);
        return new AuthResponseDto(token);
    }
}
