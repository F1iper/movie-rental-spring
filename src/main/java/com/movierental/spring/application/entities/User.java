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
public class User {

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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
