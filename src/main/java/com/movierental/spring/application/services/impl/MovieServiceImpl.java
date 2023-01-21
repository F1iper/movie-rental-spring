package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.dtos.MovieDescriptionUpdateDto;
import com.movierental.spring.application.dtos.MovieDto;
import com.movierental.spring.application.dtos.MovieTitleUpdateDto;
import com.movierental.spring.application.entities.Movie;
import com.movierental.spring.application.mappers.MovieMapper;
import com.movierental.spring.application.repositories.MovieRepository;
import com.movierental.spring.application.services.MovieService;
import com.movierental.spring.validators.CustomValidator;
import com.movierental.spring.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final CustomValidator customValidator;

    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Movie with id: " + id + " does not exist."));
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto createMovie(MovieDto dto) {
        Movie movie = movieMapper.toEntity(dto);
        movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto updateTitle(Long id, MovieTitleUpdateDto movieUpdateDto) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent() && movieUpdateDto != null) {
            Movie movie = movieOptional.get();
            customValidator.validateValueLength(movieUpdateDto.getTitle(), "Title");
            movieMapper.toDto(movie);
            movie.setTitle(movieUpdateDto.getTitle());
            movie = movieRepository.save(movie);
            return movieMapper.toDto(movie);
        }
        throw new ResourceNotFoundException("Movie with id: " + id + " not found.");
    }

    @Override
    public MovieDto updateDescription(Long id, MovieDescriptionUpdateDto movieUpdateDto) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent() && movieUpdateDto != null) {
            Movie movie = movieOptional.get();
            customValidator.validateValueLength(movieUpdateDto.getDescription(), "Description");
            movieMapper.toDto(movie);

            movie.setDescription(movieUpdateDto.getDescription());
            movie = movieRepository.save(movie);
            return movieMapper.toDto(movie);
        }
        throw new ResourceNotFoundException("Movie with id: " + id + " not found.");
    }

    @Override
    public void deleteMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Movie with id: " + id + " not found."));
        movieRepository.delete(movie);
    }

    @Override
    public boolean deleteAllMovies() {
        long countBefore = movieRepository.count();
        movieRepository.deleteAll();
        long countAfter = movieRepository.count();
        return countAfter < countBefore;
    }
}
