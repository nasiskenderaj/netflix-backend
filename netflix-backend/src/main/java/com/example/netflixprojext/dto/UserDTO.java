package com.example.netflixprojext.dto;

import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.TvShows;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String password;
    private String email;
    private List<Movie> movieList;
    private List<TvShows> tvShowsList;
    private List<Role>roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
