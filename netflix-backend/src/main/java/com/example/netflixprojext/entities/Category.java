package com.example.netflixprojext.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(gender, category.gender) && Objects.equals(movieList, category.movieList) && Objects.equals(tvShowsList, category.tvShowsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, movieList, tvShowsList);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", movieList=" + movieList +
                ", tvShowsList=" + tvShowsList +
                '}';
    }
}
