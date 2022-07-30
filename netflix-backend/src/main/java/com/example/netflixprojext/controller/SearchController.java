package com.example.netflixprojext.controller;

import com.example.netflixprojext.service.impl.MovieServiceImpl;
import com.example.netflixprojext.service.impl.TvShowsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("searchAll")
public class SearchController {

    @Autowired
    private TvShowsServiceImpl tvShowsService;

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("search")
    public ResponseEntity<?>searchByName(@RequestHeader("name")String name){
if (tvShowsService.searchByName(name)!=null){
     return ResponseEntity.ok().body(tvShowsService.searchByName(name));

}else{
    return ResponseEntity.ok().body(movieService.searchByName(name));
}



    }

}
