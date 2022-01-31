package com.movies.royal.controller;

import com.movies.royal.model.Movie;
import com.movies.royal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin_page")
public class AdminController {

    private final MovieService movieService;

    @GetMapping
    public String getPage(){
        return "page---admin";
    }

    @GetMapping("/addMovie")
    public String getAddMoviePage(Model model){
        model.addAttribute("movie",new Movie());
        return "page---movie---add";
    }

    @GetMapping("/getMovieBase")
    public String getMovieBase(Model model){
        model.addAttribute("movieList",movieService.getMovieList());
        return "page---movie---base";
    }

    @PostMapping("/addMovie")
    public String addMovie(
            @ModelAttribute("movie") Movie movie,
            @RequestParam("movie_poster")MultipartFile multipartFile
            ){
        movieService.saveMovie(movie,multipartFile);
        return "redirect:/admin_page/getMovieBase";
    }

    @GetMapping("/updateMovie/{id}")
    public String updateMovie(
            @PathVariable("id") long id,
            Model model
    ){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "page---movie---add";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(
            @PathVariable("id") long id
    ){
        movieService.deleteMovieById(id);
        return "redirect:/admin_page/getMovieBase";
    }
}
