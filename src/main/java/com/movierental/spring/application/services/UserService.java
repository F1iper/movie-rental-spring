package com.movierental.spring.application.services;

import com.movierental.spring.application.entities.Role;
import com.movierental.spring.application.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    // TODO: 1/22/23 this is not checking if user already exist
    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    // TODO: 1/22/23 implement pagination - return a page, not a full list
    List<User> getUsers();
}
