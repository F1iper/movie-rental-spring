package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.MovieDto;
import com.movierental.spring.application.entities.Movie;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MovieMapper extends BaseMapper<MovieDto, Movie> {

    @Override
    public MovieDto toDto(Movie entity) {
        MovieDto dto = new MovieDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Movie toEntity(MovieDto dto) {
        Movie entity = new Movie();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
