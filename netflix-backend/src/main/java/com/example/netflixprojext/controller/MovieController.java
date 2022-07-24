package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movieList")
    public List<MoviesDTO> getMovies(){
        System.out.println(movieService.getMovies());
        return movieService.getMovies();

    }
    @GetMapping("/movieList/{id}")
    public List<MoviesDTO> getMoviesByCategory(@PathVariable("id")Long id){
        System.out.println(movieService.findCategory(1L));
        return movieService.findCategory(id);
    }

    @GetMapping("/movieList/search")
    public MoviesDTO searchMovie(@RequestHeader("name") String name){
        System.out.println("Titanic");
        return movieService.searchByName(name);
    }
}
