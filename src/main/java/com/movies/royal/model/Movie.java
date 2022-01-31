package com.movies.royal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movie_table")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private String running_time;
    private String directed_by;
    private String produced_by;
    private String starring;
    private String description;
    private String poster_name;
    private String trailer_link;
}
