package com.movierental.spring.application.movie.service;

import com.movierental.spring.application.actor.validator.CustomValidator;
import com.movierental.spring.application.movie.dto.MovieDescriptionUpdateDto;
import com.movierental.spring.application.movie.dto.MovieDto;
import com.movierental.spring.application.movie.dto.MovieTitleUpdateDto;
import com.movierental.spring.application.movie.entity.Movie;
import com.movierental.spring.application.movie.mapper.MovieMapper;
import com.movierental.spring.application.movie.repository.MovieRepository;
import com.movierental.spring.exception.ResourceNotFoundException;
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
    public List<MovieDto> findCompanies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findById(Long id) {
        Movie company = movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Movie with id: " + id + " does not exist."));
        return movieMapper.toDto(company);
    }

    @Override
    public MovieDto add(MovieDto dto) {
        Movie company = movieMapper.toEntity(dto);
        movieRepository.save(company);
        return movieMapper.toDto(company);
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
    public boolean deleteById(Long id) {
        Movie company = movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Movie with id: " + id + " not found."));
        movieRepository.delete(company);
        return true;
    }

    @Override
    public boolean deleteAll() {
        long countBefore = movieRepository.count();
        movieRepository.deleteAll();
        long countAfter = movieRepository.count();
        return countAfter < countBefore;
    }
}
