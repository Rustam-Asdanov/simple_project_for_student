package com.movies.royal.controller;

import com.movies.royal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin_page")
public class AdminController {

    private final MovieService movieService;

    @GetMapping
    public String getPage(){
        return "page---admin";
    }
}
