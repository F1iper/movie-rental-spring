package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDescriptionUpdateDto {

    private Long id;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 10, max = 255, message = "must be between 10 and 255 characters.")
    private String description;
}
