package com.movierental.spring;

import com.movierental.spring.configuration.token.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MovieRentalSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalSpringApplication.class, args);
    }

}
