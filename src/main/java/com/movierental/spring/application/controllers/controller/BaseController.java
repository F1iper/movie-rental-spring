package com.movierental.spring.application.controllers.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseController<T> {

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(Long id);

    ResponseEntity<T> create(T model);

    ResponseEntity<Void> deleteById(Long id);

    ResponseEntity<Void> deleteAll();
}
