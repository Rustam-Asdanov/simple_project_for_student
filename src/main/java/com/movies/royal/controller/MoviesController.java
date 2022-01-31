package com.movies.royal.controller;

import com.movies.royal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/royal_movies")
public class MoviesController {

    private final MovieService movieService;

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("movieList",movieService.getMovieList());
        return "page---movies";
    }

}
