package com.movierental.spring.application.movie.service;

import com.movierental.spring.application.movie.dto.MovieDescriptionUpdateDto;
import com.movierental.spring.application.movie.dto.MovieDto;
import com.movierental.spring.application.movie.dto.MovieTitleUpdateDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findCompanies();

    MovieDto findById(Long id);

    MovieDto add(MovieDto dto);

    MovieDto updateTitle(Long id, MovieTitleUpdateDto movieUpdateDto);

    boolean deleteById(Long id);

    boolean deleteAll();

    MovieDto updateDescription(Long id, MovieDescriptionUpdateDto updateDto);
}
