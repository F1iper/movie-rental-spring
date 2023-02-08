package com.movierental.spring.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loadAppUserByUsername(String username) throws UsernameNotFoundException;
}
