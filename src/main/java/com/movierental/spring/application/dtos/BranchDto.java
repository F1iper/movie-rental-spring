package com.movierental.spring.application.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private Long id;

    @Column(nullable = false)
    @Length(min = 2, max = 40)
    private String name;
}
