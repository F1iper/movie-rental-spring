package com.movierental.spring.application.actor.dto;

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
public class ActorDto {

    private Long id;

    @Column(nullable = false)
    @Length(min = 3, max = 40)
    private String firstname;

    @Column(nullable = false)
    @Length(min = 3, max = 40)
    private String lastname;
}
