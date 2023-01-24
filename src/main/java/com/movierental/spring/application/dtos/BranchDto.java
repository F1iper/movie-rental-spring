package com.movierental.spring.application.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private Long id;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String name;
}
