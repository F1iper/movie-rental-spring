package com.movierental.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CustomErrorResponse {

    private final int status;
    private final String message;
    private final String description;
    private final LocalDateTime timestamp;
}
