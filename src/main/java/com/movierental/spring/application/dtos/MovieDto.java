package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long movieId;

    @Length(min = 3, max = 40)
    private String title;

    @Length(min = 10, max = 255)
    private String description;

    @Min(1887)
    private int releaseYear;

    @Positive
    private int length;

    private Long languageId;

    @PositiveOrZero
    private double cost;

    private Long statusId;

    @PositiveOrZero
    private double rentalRate;

    private Long movieTypeId;

}
