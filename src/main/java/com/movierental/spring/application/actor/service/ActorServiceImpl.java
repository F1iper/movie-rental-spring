package com.movierental.spring.application.actor.service;

import com.movierental.spring.application.actor.dto.ActorDto;
import com.movierental.spring.application.actor.dto.ActorUpdateDto;
import com.movierental.spring.application.actor.entity.Actor;
import com.movierental.spring.application.actor.mapper.ActorMapper;
import com.movierental.spring.application.actor.repository.ActorRepository;
import com.movierental.spring.application.actor.validator.CustomValidator;
import com.movierental.spring.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final CustomValidator customValidator;

    @Override
    public List<ActorDto> findAll() {
        List<Actor> actors = actorRepository.findAll();
        return actors.stream()
                .map(actor -> new ActorDto(actor.getId(), actor.getFirstname(), actor.getLastname()))
                .collect(Collectors.toList());
    }

    @Override
    public ActorDto findById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor with id: " + id + " does not exist."));
        return actorMapper.toDto(actor);
    }

    @Override
    public ActorDto add(ActorDto dto) {
        customValidator.validateValueLength(dto.getFirstname(), "Actor firstname");
        customValidator.validateValueLength(dto.getLastname(), "Actor lastname");
        Actor actor = actorMapper.toEntity(dto);
        actorRepository.save(actor);
        return actorMapper.toDto(actor);
    }

    public ActorDto updateFirstname(Long id, ActorUpdateDto newValue) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            Actor actor = actorOptional.get();
            if (newValue != null) {
                customValidator.validateValueLength(newValue.getFirstname(), "firstname");
                actor.setFirstname(newValue.getFirstname());
            }

            actor = actorRepository.save(actor);
            return actorMapper.toDto(actor);
        }
        throw new ResourceNotFoundException("Actor with id: " + id + " not found.");
    }

    public ActorDto updateLastname(Long id, ActorUpdateDto newValue) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            Actor actor = actorOptional.get();
            if (newValue != null) {
                customValidator.validateValueLength(newValue.getLastname(), "lastname");
                actor.setLastname(newValue.getLastname());
            }

            actor = actorRepository.save(actor);
            return actorMapper.toDto(actor);
        }
        throw new ResourceNotFoundException("Actor with id: " + id + " not found.");
    }

    @Override
    public boolean deleteById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Actor with id: " + id + " not found."));
        actorRepository.delete(actor);
        return true;
    }

    @Override
    public boolean deleteAll() {
        long countBefore = actorRepository.count();
        actorRepository.deleteAll();
        long countAfter = actorRepository.count();
        return countAfter < countBefore;
    }
}
