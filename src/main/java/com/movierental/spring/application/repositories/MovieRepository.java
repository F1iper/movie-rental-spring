package com.movierental.spring.application.repositories;

import com.movierental.spring.application.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
