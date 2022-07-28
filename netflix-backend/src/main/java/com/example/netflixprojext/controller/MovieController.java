package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.errorHandling.NotFoundException;
import com.example.netflixprojext.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("/movieList")
    public List<MoviesDTO> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("saveMovie")
    public Movie save(@RequestBody  MoviesDTO moviesDTO){
        return movieService.save(moviesDTO);
    }

    @PutMapping("updateMovie")
    public Movie update(@RequestBody MoviesDTO moviesDTO){
        return movieService.save(moviesDTO);
    }


    @GetMapping("/movie/{id}")
    public MoviesDTO getById(@PathVariable Long id){
        MoviesDTO movie = movieService.getById(id);
        if(movie==null){
            throw new NotFoundException("Movie with id "+id+" not found.");
        }
        return movie;
    }

    @DeleteMapping("/removeMovie/{id}")
    public int removeById(@PathVariable Long id){
        int movie = movieService.removeById(id);

        if(movie==0){
            throw new NotFoundException("Movie with id "+id+" not found.");
        }
        return movie;
    }

    @PostMapping("/addMovie/{userName},{movieId}")
    public void addMovieToUser(@PathVariable String userName, @PathVariable Long movieId){
        movieService.addMovieToUser(userName,movieId);
    }



    @GetMapping("/movieList/search")
    public MoviesDTO searchMovie(@RequestHeader("name") String name){
        MoviesDTO movie = movieService.searchByName(name);
        if(movie==null){
            throw new NotFoundException("Movie with name "+name+" not found.");
        }
        return movie;
    }




    @GetMapping("/movieList/{id}")
    public List<MoviesDTO> getMoviesByCategory(@PathVariable("id")Long id){
        List<MoviesDTO> movie = movieService.findCategory(id);
        if(movie==null){
            throw new NotFoundException("Movie with category-id "+id+" not found.");
        }
        return movie;

    }


}
