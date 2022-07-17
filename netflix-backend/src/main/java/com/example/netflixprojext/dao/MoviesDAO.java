package com.example.netflixprojext.dao;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Movie;

import java.util.List;

public interface MoviesDAO {

    List<MoviesDTO> getAll();

    Movie add(MoviesDTO dto);

    MoviesDTO getById(Long id);

    int removeById(Long id);


}
