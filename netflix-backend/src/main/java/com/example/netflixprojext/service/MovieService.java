package com.example.netflixprojext.service;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Movie;

import java.util.List;

public interface MovieService {

     List<MoviesDTO> getMovies();
     Movie save(MoviesDTO moviesDTO);
     MoviesDTO getById(Long id);
     int removeById(Long id);
     void addMovieToUser(String name,Long id);
     MoviesDTO searchByName(String name);
     List<MoviesDTO> findCategory(Long id);
}
