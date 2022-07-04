package com.example.netflixprojext.entities;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;

    @OneToOne(mappedBy = "category")
    private Movie movie;

    @OneToOne(mappedBy = "category")
    private TvShows tvShows;

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


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public TvShows getTvShows() {
        return tvShows;
    }

    public void setTvShows(TvShows tvShows) {
        this.tvShows = tvShows;
    }


}
