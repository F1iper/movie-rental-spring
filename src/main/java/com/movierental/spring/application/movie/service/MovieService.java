package com.movierental.spring.application.movie.service;

import com.movierental.spring.application.movie.dto.MovieDescriptionUpdateDto;
import com.movierental.spring.application.movie.dto.MovieDto;
import com.movierental.spring.application.movie.dto.MovieTitleUpdateDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAllMovies();

    MovieDto findMovieById(Long id);

    MovieDto createMovie(MovieDto dto);

    MovieDto updateTitle(Long id, MovieTitleUpdateDto movieUpdateDto);

    void deleteMovieById(Long id);

    boolean deleteAllMovies();

    MovieDto updateDescription(Long id, MovieDescriptionUpdateDto updateDto);
}
