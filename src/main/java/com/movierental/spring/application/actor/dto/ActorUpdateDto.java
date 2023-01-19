package com.movierental.spring.application.actor.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorUpdateDto {

    @Length(min = 3, max = 30)
    @Nullable
    private String firstname;

    @Length(min = 3, max = 40)
    @Nullable
    private String lastname;
}
