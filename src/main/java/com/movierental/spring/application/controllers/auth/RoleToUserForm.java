package com.movierental.spring.application.controllers.auth;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String username;
    private String roleName;
}
