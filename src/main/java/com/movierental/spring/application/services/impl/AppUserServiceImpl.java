package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.entities.Role;
import com.movierental.spring.application.repositories.AppUserRepository;
import com.movierental.spring.application.repositories.RoleRepository;
import com.movierental.spring.application.services.AppUserService;
import com.movierental.spring.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to db", appUser.getUsername());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to db", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        log.info("Adding role {} to user {} ", roleName, username);
        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User with username: " + username + " does not exist."));
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getAppUser(String username) {
        log.info("Fetching user {} ", username);
        return appUserRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User with username: " + username + " does not exist."));
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching users");
        return appUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalUser = appUserRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            log.info("User not found in DB");
            throw new UsernameNotFoundException("User not found in DB");
        }
        AppUser user = optionalUser.get();
        log.info("User found in DB: {}", username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
