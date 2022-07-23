package com.example.netflixprojext.dao;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.TvShows;

import java.util.List;

public interface TvShowsDAO {
    List<TvShowsDTO> getAll();

    TvShows add(TvShowsDTO dto);

    TvShowsDTO getById(Long id);

    int removeById(Long id);
}
