package com.movierental.spring.exceptions.handler;

import com.movierental.spring.exceptions.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomErrorResponse> handleConstraintViolation(DataIntegrityViolationException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValidExceptions(MethodArgumentNotValidException e) {
//        return createCustomErrorExceptionResponseAsList(e);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        return createCustomErrorExceptionResponseAsList(e);
    }

    @ExceptionHandler(EmptyValueException.class)
    public ResponseEntity<CustomErrorResponse> handleEmptyValueException(EmptyValueException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

    @ExceptionHandler({InvalidDataLengthException.class})
    public ResponseEntity<CustomErrorResponse> handleInvalidDataLengthException(InvalidDataLengthException e) {
        return createCustomErrorExceptionResponse(e.getMessage());
    }

    private static ResponseEntity<CustomErrorResponse> createCustomErrorExceptionResponse(String e) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e,
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<CustomErrorResponse> createCustomErrorExceptionResponseAsList(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder sb = new StringBuilder();

        for (FieldError error : fieldErrors) {
            sb.append(error.getField() + ": " + error.getDefaultMessage() + ", ");
        }
        return createCustomErrorExceptionResponse(e.getMessage());
    }
}
