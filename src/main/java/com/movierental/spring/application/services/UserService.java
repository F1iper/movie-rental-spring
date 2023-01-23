package com.movierental.spring.application.services;

import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    // TODO: 1/22/23 this is not checking if user already exist
    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    // TODO: 1/22/23 implement pagination - return a page, not a full list
    List<AppUser> getUsers();
}
