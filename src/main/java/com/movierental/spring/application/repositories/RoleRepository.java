package com.movierental.spring.application.repositories;

import com.movierental.spring.application.controllers.auth.ERole;
import com.movierental.spring.application.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
