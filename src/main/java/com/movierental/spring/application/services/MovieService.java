package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.MovieDescriptionUpdateDto;
import com.movierental.spring.application.dtos.MovieDto;
import com.movierental.spring.application.dtos.MovieTitleUpdateDto;

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
