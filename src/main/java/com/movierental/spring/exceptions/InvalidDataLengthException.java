package com.movierental.spring.exceptions;

public class InvalidDataLengthException extends RuntimeException {
    public InvalidDataLengthException(String message) {
        super(message);
    }
}
