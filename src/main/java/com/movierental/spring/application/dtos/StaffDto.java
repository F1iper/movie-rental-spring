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
public class StaffDto {

    private Long staffId;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String firstname;

    @NotEmpty(message = "cannot be empty.")
    @Length(min = 2, max = 30, message = "must be between 2 and 30 characters.")
    private String lastname;

    @Min(value = 2500, message = "Salary must be at least 2500.")
    @NotNull(message = "cannot be empty.")
    private Double salary;

}
