package com.movierental.spring.application.controllers.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {


}
