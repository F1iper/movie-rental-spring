package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieTitleUpdateDto {

    private Long id;

    @Length(min = 5, max = 40)
    private String title;
}
