package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long movieId;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String title;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 10, max = 255, message = "must be between 2 and 30 characters.")
    private String description;

    @NotNull(message = "cannot be empty.")
    @Min(value = 1887, message = "cannot be before 1887.")
    @Max(value = 2030, message = "cannot be after 2030.")
    private Integer releaseYear;

    @Min(value = 10, message = "cannot be shorter than 10")
    @Max(value = 240, message = "cannot be longer than 240")
    @NotNull(message = "cannot be empty.")
    private Integer length;

    private Long languageId;

    @NotNull(message = "cannot be empty.")
    @DecimalMin(value = "0.0", message = "cannot be lower than 0.0")
    private Double cost;

    private Long statusId;

    @NotNull(message = "cannot be empty.")
    @DecimalMin(value = "0.0", message = "cannot be lower than 0.0")
    private Double rentalRate;

    private Long movieTypeId;

}
