package com.movierental.spring.exceptions;

public class EmptyValueException extends RuntimeException {
    public EmptyValueException(String message) {
        super(message);
    }
}
