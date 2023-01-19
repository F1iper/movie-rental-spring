package com.movierental.spring.application.actor.service;

import com.movierental.spring.application.actor.dto.ActorDto;
import com.movierental.spring.application.actor.dto.ActorUpdateDto;

import java.util.List;

public interface ActorService {

    List<ActorDto> findAll();

    ActorDto findById(Long id);

    ActorDto add(ActorDto dto);

    ActorDto updateFirstname(Long id, ActorUpdateDto newValue);

    ActorDto updateLastname(Long id, ActorUpdateDto newValue);

    boolean deleteById(Long id);

    boolean deleteAll();
}
