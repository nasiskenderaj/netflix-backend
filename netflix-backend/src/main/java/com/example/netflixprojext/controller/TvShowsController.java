package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.service.TvShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tvShows")
public class TvShowsController {

    @Autowired
    TvShowsService tvShowsService;

    @GetMapping("/tvShowsList")
    public List<TvShowsDTO> getTvShows(){
        System.out.println(tvShowsService.getTvShows());
        return tvShowsService.getTvShows();

    }


    @GetMapping("/{name}")
    public TvShowsDTO searchTvShows(@PathVariable("name")String name){
        return tvShowsService.searchByName(name);
    }


}
