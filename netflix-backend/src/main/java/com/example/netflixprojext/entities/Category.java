package com.example.netflixprojext.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
@JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Movie> movieList;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<TvShows> tvShowsList;

    public Category(String gender) {

        this.gender = gender;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<TvShows> getTvShowsList() {
        return tvShowsList;
    }

    public void setTvShowsList(List<TvShows> tvShowsList) {
        this.tvShowsList = tvShowsList;
    }


}
