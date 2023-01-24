package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.AppUserDto;
import com.movierental.spring.application.dtos.RegisterDto;

public interface RegisterService {

    AppUserDto register(RegisterDto registerDto);

}
