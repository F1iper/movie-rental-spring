package com.movierental.spring.application.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    private String title;
    private String description;
    private int releaseYear;
    private int length;
    private Long languageId;
    private double cost;
    private Long statusId;
    private double rentalRate;
    private Long movieTypeId;
}
