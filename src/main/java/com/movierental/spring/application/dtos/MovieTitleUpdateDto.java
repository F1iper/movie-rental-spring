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
public class MovieTitleUpdateDto {

    private Long id;

    @Size(min = 2, max = 40, message = "must be between 2 and 40 characters.")
    @NotEmpty(message = "cannot be empty.")
    private String title;
}
