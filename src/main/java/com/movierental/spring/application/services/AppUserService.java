package com.movierental.spring.application.services;

import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToAppUser(String username, String roleName);

    AppUser getAppUser(String username);

    List<AppUser> getUsers();
}
