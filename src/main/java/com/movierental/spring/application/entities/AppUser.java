package com.movierental.spring.application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String name;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String username;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 8, max = 30, message = "must be between 8 and 30 characters.")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "app_user_roles", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
}
