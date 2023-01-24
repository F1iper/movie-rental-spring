package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieTitleUpdateDto {

    private Long id;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 40, message = "must be between 2 and 40 characters.")
    private String title;
}
