package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.AppUserDto;
import com.movierental.spring.application.dtos.AuthResponseDto;
import com.movierental.spring.application.dtos.LoginDto;
import com.movierental.spring.application.dtos.RegisterDto;

public interface RegisterService {

    AppUserDto register(RegisterDto registerDto);

    AuthResponseDto login(LoginDto loginDto);
}
