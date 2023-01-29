package com.movierental.spring.application.controllers.auth;

import com.movierental.spring.application.dtos.RoleToUserForm;
import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;
import com.movierental.spring.application.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getUsers() {
        return new ResponseEntity<>(appUserService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveAppUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        appUserService.addRoleToAppUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }
}
