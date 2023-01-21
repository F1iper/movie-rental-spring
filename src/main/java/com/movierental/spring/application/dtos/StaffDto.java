package com.movierental.spring.application.dtos;

import com.movierental.spring.application.entities.Branch;
import com.movierental.spring.application.entities.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StaffDto {

    private Long staffId;

    @NotEmpty(message = "Firstname cannot be empty.")
    @Size(min = 2, max = 30, message = "Firstname must be between 2 and 30 characters.")
    private String firstname;

    @NotEmpty(message = "Lastname cannot be empty.")
    @Size(min = 2, max = 30, message = "lastname must be between 2 and 30 characters.")
    private String lastname;

    @Min(value = 2500, message = "Salary must be at least 2500.")
    private Double salary;

}
