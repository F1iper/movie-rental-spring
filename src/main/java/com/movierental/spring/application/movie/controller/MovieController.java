package com.movierental.spring.application.movie.controller;

import com.movierental.spring.application.movie.dto.MovieDescriptionUpdateDto;
import com.movierental.spring.application.movie.dto.MovieDto;
import com.movierental.spring.application.movie.dto.MovieTitleUpdateDto;
import com.movierental.spring.application.movie.service.MovieService;
import com.movierental.spring.base.controller.BaseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController implements BaseController<MovieDto> {

    private final MovieService movieService;

    @GetMapping
    @Override
    public ResponseEntity<List<MovieDto>> findAll() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.findMovieById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody @Valid MovieDto dto) {
        return new ResponseEntity<>(movieService.createMovie(dto), HttpStatus.CREATED);
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
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Override
    public ResponseEntity deleteAll() {
        if (movieService.deleteAllMovies()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
