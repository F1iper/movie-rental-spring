package com.movierental.spring.application.actor.controller;

import com.movierental.spring.application.actor.dto.ActorDto;
import com.movierental.spring.application.actor.dto.ActorUpdateDto;
import com.movierental.spring.application.actor.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorDto>> findAllActors() {
        return new ResponseEntity<>(actorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> findActorById(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActorDto> addActor(@RequestBody ActorDto dto) {
        return new ResponseEntity<>(actorService.add(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/firstname")
    public ResponseEntity<ActorDto> updateActorFirstname(@PathVariable Long id, @RequestBody ActorUpdateDto newValue) {
        return new ResponseEntity<>(actorService.updateFirstname(id, newValue), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}/lastname")
    public ResponseEntity<ActorDto> updateActorLastname(@PathVariable Long id, @RequestBody ActorUpdateDto newValue) {
        return new ResponseEntity<>(actorService.updateLastname(id, newValue), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteActorById(@PathVariable Long id) {
        actorService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllActors() {
        if (actorService.deleteAll()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
