package com.movierental.spring.application.movie.repository;

import com.movierental.spring.application.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
