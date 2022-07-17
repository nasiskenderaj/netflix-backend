package com.example.netflixprojext.dao.impl;

import com.example.netflixprojext.dao.MoviesDAO;
import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.entities.Category;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.repository.CategoryRepository;
import com.example.netflixprojext.repository.MovieRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MoviesDAOImpl implements MoviesDAO {

    private MovieRepository movieRepository;

    private CategoryRepository categoryRepository;
    @Override
    public List<MoviesDTO> getAll() {
        return movieRepository.findAll().stream().map(MoviesDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Movie add(MoviesDTO dto) {
        return movieRepository.save(mapToEntity(dto));
    }

    @Override
    public MoviesDTO getById(Long id) {

        Optional<Movie> optional = movieRepository.findById(id);
        return optional.map(MoviesDAOImpl::mapToDTO).orElse(null);
    }

    @Override
    public int removeById(Long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if(optional.isPresent()){
            movieRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    public List<MoviesDTO> findByCategory(Long id){


        List<Movie> movieList=movieRepository.findAll();
        return movieList.stream().filter(c->c.getCategory()==getCategoryById(id)).map(MoviesDAOImpl::mapToDTO).collect(Collectors.toList());
    }

    public MoviesDTO searchByName(String name){
        List<Movie> movieList=movieRepository.findAll();
        Optional<MoviesDTO> optional = movieList.stream().filter(c -> c.getTitle() == name).map(MoviesDAOImpl::mapToDTO).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        else {
            return null;
        }

    }

    public static Movie mapToEntity(MoviesDTO moviesDTO){
        Movie movie=new Movie();

        movie.setTitle(moviesDTO.getTitle());

        movie.setDescription(moviesDTO.getDescription());
        movie.setCategory(moviesDTO.getCategory());
        movie.setDuration(moviesDTO.getDuration());
        movie.setImageUrl(moviesDTO.getImageUrl());
        movie.setId(moviesDTO.getId());
        movie.setUrl(moviesDTO.getUrl());

        return movie;

    }

    public static MoviesDTO mapToDTO(Movie movie){
        if(movie == null)
            return null;

        MoviesDTO moviesDTO=new MoviesDTO();

        moviesDTO.setTitle(movie.getTitle());
        moviesDTO.setDescription(movie.getDescription());
        moviesDTO.setCategory(movie.getCategory());
        moviesDTO.setDuration(movie.getDuration());
        moviesDTO.setImageUrl(movie.getImageUrl());
        moviesDTO.setId(movie.getId());
        moviesDTO.setUrl(movie.getUrl());
        return moviesDTO;

    }

    public Category getCategoryById(Long id){
        List<Category>categoryList=categoryRepository.findAll();
        Optional<Category> first = categoryList.stream().filter(s -> Objects.equals(s.getId(), id)).findFirst();
        if (first.isPresent()){

            return first.get();
        }
        return null;
    }
}
