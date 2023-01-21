package com.movierental.spring.application.controllers;

import com.movierental.spring.application.dtos.ActorDto;
import com.movierental.spring.application.dtos.ActorUpdateDto;
import com.movierental.spring.application.services.ActorService;
import com.movierental.spring.application.controllers.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
@RequiredArgsConstructor
public class ActorController implements BaseController<ActorDto> {

    private final ActorService actorService;

    @GetMapping
    @Override
    public ResponseEntity<List<ActorDto>> findAll() {
        return new ResponseEntity<>(actorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ActorDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.findActorById(id), HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ActorDto> create(@RequestBody @Valid ActorDto dto) {
        return new ResponseEntity<>(actorService.createActor(dto), HttpStatus.CREATED);
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
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {
        actorService.deleteActorById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping
    @Override
    public ResponseEntity deleteAll() {
        if (actorService.deleteAllActors()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
