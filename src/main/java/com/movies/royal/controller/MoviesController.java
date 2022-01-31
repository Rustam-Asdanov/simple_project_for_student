package com.movies.royal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/royal-movies")
public class MoviesController {

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("movieList",null);
        return "page---movies";
    }
}
