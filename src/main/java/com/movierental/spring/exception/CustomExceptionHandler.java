package com.movierental.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({EmptyValueException.class})
    public ResponseEntity<CustomErrorResponse> handleEmptyValueException(EmptyValueException e, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<CustomErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidDataLengthException.class})
    public ResponseEntity<CustomErrorResponse> handleInvalidDataLengthException(InvalidDataLengthException e, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getDescription(false),
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
