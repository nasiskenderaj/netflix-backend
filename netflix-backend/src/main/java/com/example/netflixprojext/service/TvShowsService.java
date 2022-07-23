package com.example.netflixprojext.service;

import com.example.netflixprojext.dao.impl.TvShowsDAOImpl;
import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.TvShows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvShowsService {

    @Autowired
    private TvShowsDAOImpl tvShowsDAO;



    public List<TvShowsDTO> getTvShows(){
        return tvShowsDAO.getAll();
    }

    public TvShows save(TvShowsDTO tvShowsDTO){
        return tvShowsDAO.add(tvShowsDTO);
    }

    public TvShowsDTO getById(Long id){
        return tvShowsDAO.getById(id);
    }

    public int removeById(Long id){
        return tvShowsDAO.removeById(id);
    }

    public TvShowsDTO searchByName(String name){
        return tvShowsDAO.searchByTitle(name);
    }

}

