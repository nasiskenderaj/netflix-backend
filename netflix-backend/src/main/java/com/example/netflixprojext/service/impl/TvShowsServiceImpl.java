package com.example.netflixprojext.service.impl;

import com.example.netflixprojext.dao.impl.TvShowsDAOImpl;
import com.example.netflixprojext.dto.TvShowsDTO;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.service.TvShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvShowsServiceImpl implements TvShowsService {

    @Autowired
    private TvShowsDAOImpl tvShowsDAO;



    @Override
    public List<TvShowsDTO> getTvShows(){
        return tvShowsDAO.getAll();
    }

    @Override
    public TvShows save(TvShowsDTO tvShowsDTO){
        return tvShowsDAO.add(tvShowsDTO);
    }

    @Override
    public TvShowsDTO getById(Long id){
        return tvShowsDAO.getById(id);
    }

    @Override
    public int removeById(Long id){
        return tvShowsDAO.removeById(id);
    }

    @Override
    public TvShowsDTO searchByName(String name){
        return tvShowsDAO.searchByTitle(name);
    }

    @Override
    public void addShowToUser(String name, Long id) {
        tvShowsDAO.addShowToUser(name,id);

    }

}

