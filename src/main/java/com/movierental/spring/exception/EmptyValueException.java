package com.movierental.spring.exception;

public class EmptyValueException extends RuntimeException {
    public EmptyValueException(String message) {
        super(message);
    }
}
