package com.movierental.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {

    private String fieldName;
    private Object rejectedValue;
    private String message;
}
