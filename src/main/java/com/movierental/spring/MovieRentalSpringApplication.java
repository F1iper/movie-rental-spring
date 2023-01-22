package com.movierental.spring;

import com.movierental.spring.application.entities.Role;
import com.movierental.spring.application.entities.User;
import com.movierental.spring.application.services.UserService;
import com.movierental.spring.configuration.token.RsaKeyProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MovieRentalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRentalSpringApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
		userService.saveRole(new Role(null, "ROLE_USER"));
		userService.saveRole(new Role(null, "ROLE_ADMIN"));
		userService.saveRole(new Role(null, "ROLE_MANAGER"));
		userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

		userService.saveUser(new User(null, "John Travolta", "john225", "12345678", new ArrayList<>()));
		userService.saveUser(new User(null, "Will Smith", "legendnotreally", "87654321", new ArrayList<>()));
		userService.saveUser(new User(null, "Jim Carey", "aceventura", "password123", new ArrayList<>()));
		userService.saveUser(new User(null, "John Rambo", "john00700", "superpassword", new ArrayList<>()));

		userService.addRoleToUser("john225", "ROLE_USER");
		userService.addRoleToUser("legendnotreally", "ROLE_ADMIN");
		userService.addRoleToUser("legendnotreally", "ROLE_USER");
		userService.addRoleToUser("legendnotreally", "ROLE_MANAGER");
		userService.addRoleToUser("aceventura", "ROLE_MANAGER");
		userService.addRoleToUser("aceventura", "ROLE_SUPER_ADMIN");
		userService.addRoleToUser("aceventura", "ROLE_ADMIN");
		userService.addRoleToUser("john00700", "ROLE_SUPER_ADMIN");
		userService.addRoleToUser("john00700", "ROLE_USER");

		};
	}
}
