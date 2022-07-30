package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.errorHandling.NotFoundException;
import com.example.netflixprojext.service.impl.MovieServiceImpl;
import com.example.netflixprojext.service.impl.TvShowsServiceImpl;
import com.example.netflixprojext.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permission")
public class SaveUpdateController {

    private final UserServiceImpl userServiceImpl;

    private final MovieServiceImpl movieService;

    private final TvShowsServiceImpl tvShowsService;


    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public int removeUserById(@PathVariable Long id) {
        int user = userServiceImpl.removeById(id);

        if(user==0){
            throw new NotFoundException("User with id "+id+" not found.");
        }
        return user;
    }

    @PostMapping("/saveMovie")
    public Movie saveMovie(@RequestBody MoviesDTO moviesDTO){
        return movieService.save(moviesDTO);
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody MoviesDTO moviesDTO){
        return movieService.save(moviesDTO);
    }

    @DeleteMapping("/removeMovie/{id}")
    public int removeMovieById(@PathVariable Long id){
        int movie = movieService.removeById(id);

        if(movie==0){
            throw new NotFoundException("Movie with id "+id+" not found.");
        }
        return movie;
    }

    @PostMapping("/save")
    public TvShows saveTvShowUser(TvShowsDTO tvShowsDTO){
        return tvShowsService.save(tvShowsDTO);

    }

    @DeleteMapping("/delete/{id}")
    public int removeByIdTvShowUser(@PathVariable Long id){
        int show = tvShowsService.removeById(id);

        if(show==0){
            throw new NotFoundException("TvShow with id "+id+" not found.");
        }
        return show;
    }

    @PutMapping("/update")
    public TvShows updateTvShowUser(TvShowsDTO tvShowsDTO){
        return tvShowsService.save(tvShowsDTO);
    }


}
