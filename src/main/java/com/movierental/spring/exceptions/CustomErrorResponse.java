package com.movierental.spring.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
