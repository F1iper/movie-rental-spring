package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long movieId;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String title;

    @NotEmpty(message = "cannot be empty.")
    @Size(min = 10, max = 255, message = "must be between 2 and 30 characters.")
    private String description;

    @NotEmpty(message = "cannot be empty.")
    @Min(value = 1887, message = "cannot be before 1887.")
    @Max(value = 2030, message = "cannot be after 2030.")
    private int releaseYear;

    @Min(value = 10, message = "cannot be shorter than 10")
    @Max(value = 240, message = "cannot be longer than 240")
    @NotEmpty(message = "cannot be empty.")
    private int length;

    private Long languageId;

    @NotEmpty(message = "cannot be empty.")
    @DecimalMin(value = "0.0", message = "cannot be lower than 0.0")
    private double cost;

    private Long statusId;

    @NotEmpty(message = "cannot be empty.")
    @DecimalMin(value = "0.0", message = "cannot be lower than 0.0")
    private double rentalRate;

    private Long movieTypeId;

}
