package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.service.TvShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/search")
    public TvShowsDTO searchTvShows(@RequestHeader("searchname") String name){
        return tvShowsService.searchByName(name);
    }


}
