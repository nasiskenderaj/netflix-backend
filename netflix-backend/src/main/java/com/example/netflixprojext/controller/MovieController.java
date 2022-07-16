package com.example.netflixprojext.controller;

import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/moviesList")
    public List<Movie> getMovies(){
        System.out.println(movieService.getMovies());
        return movieService.getMovies();

    }
}
