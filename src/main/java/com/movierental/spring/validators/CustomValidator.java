package com.movierental.spring.validators;

import com.movierental.spring.exceptions.InvalidDataLengthException;
import org.springframework.stereotype.Service;

@Service
public class CustomValidator {

    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 40;

    public void validateValueLength(String valueName, String messageInfo) {
        if (valueName == null) {
            throw new InvalidDataLengthException(messageInfo + " cannot be null");
        }
        if (valueName.length() < MIN_NAME_LENGTH) {
            throw new InvalidDataLengthException(messageInfo + " must have a minimum length of " + MIN_NAME_LENGTH + " characters.");
        }
        if (valueName.length() > MAX_NAME_LENGTH) {
            throw new InvalidDataLengthException(messageInfo + " must have a maximum length of " + MAX_NAME_LENGTH + " characters.");
        }
    }
}
