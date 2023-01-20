package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.ActorDto;
import com.movierental.spring.application.dtos.ActorUpdateDto;

import java.util.List;

public interface ActorService {

    List<ActorDto> findAll();

    ActorDto findActorById(Long id);

    ActorDto createActor(ActorDto dto);

    ActorDto updateFirstname(Long id, ActorUpdateDto newValue);

    ActorDto updateLastname(Long id, ActorUpdateDto newValue);

    void deleteActorById(Long id);

    boolean deleteAllActors();
}
