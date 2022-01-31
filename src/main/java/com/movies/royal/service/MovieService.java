package com.movies.royal.service;

import com.movies.royal.model.Movie;
import com.movies.royal.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovieList(){
        return movieRepository.findAll();
    }

}
