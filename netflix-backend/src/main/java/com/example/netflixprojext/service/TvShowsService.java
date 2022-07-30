package com.example.netflixprojext.service;

import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.TvShows;

import java.util.List;

public interface TvShowsService {
    List<TvShowsDTO> getTvShows();
    TvShows save(TvShowsDTO tvShowsDTO);
    TvShowsDTO getById(Long id);
    int removeById(Long id);
    TvShowsDTO searchByName(String name);
    void addShowToUser(String name,Long id);

}
