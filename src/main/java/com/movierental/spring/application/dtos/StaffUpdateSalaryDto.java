package com.movierental.spring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffUpdateSalaryDto {

    @Digits(integer = 5, fraction = 2, message = "must be a decimal number with 1 to 5 digits " +
            "before and 2 after the decimal point, for example, '3.14' or '1245.00'\"")
    @DecimalMin(value = "0", message = "cannot be lower than 0")
    @NotNull
    private double salary;
}
