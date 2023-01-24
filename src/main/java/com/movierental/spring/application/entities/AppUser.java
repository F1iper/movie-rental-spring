package com.movierental.spring.application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @Nullable
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String name;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String username;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 8, message = "must contain more than 8 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "app_user_roles", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
}
