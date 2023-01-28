package com.movierental.spring.application.services;

import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
