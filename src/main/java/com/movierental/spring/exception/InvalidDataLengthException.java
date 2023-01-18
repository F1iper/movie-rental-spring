package com.movierental.spring.exception;

public class InvalidDataLengthException extends RuntimeException {
    public InvalidDataLengthException(String message) {
        super(message);
    }
}
