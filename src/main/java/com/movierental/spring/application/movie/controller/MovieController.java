package com.movierental.spring.application.movie.controller;

import com.movierental.spring.application.movie.dto.MovieDescriptionUpdateDto;
import com.movierental.spring.application.movie.dto.MovieDto;
import com.movierental.spring.application.movie.dto.MovieTitleUpdateDto;
import com.movierental.spring.application.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAllMovies() {
        return new ResponseEntity<>(movieService.findCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findMovieById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieDto dto) {
        return new ResponseEntity<>(movieService.add(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/title")
    public ResponseEntity<MovieDto> updateMovieTitle(@PathVariable Long id, @RequestBody MovieTitleUpdateDto updateDto) {
        return new ResponseEntity<>(movieService.updateTitle(id, updateDto), HttpStatus.OK);
    }

    @PatchMapping("/{id}/description")
    public ResponseEntity<MovieDto> updateMovieDescription(@PathVariable Long id, @RequestBody MovieDescriptionUpdateDto updateDto) {
        return new ResponseEntity<>(movieService.updateDescription(id, updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovieById(@PathVariable Long id) {
        movieService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllMovies() {
        if (movieService.deleteAll()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
