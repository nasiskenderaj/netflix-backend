package com.example.netflixprojext.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int age;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "movies_user",
            joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movieList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "tvShows_user",
            joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "tvShows_id"))
    private List<TvShows> tvShowsList;



    public User() {

    }

    public User(UserBuilder userBuilder) {

        this.name=userBuilder.name;
        this.age=userBuilder.age;
        this.email=userBuilder.email;
        this.surname=userBuilder.surname;
        this.password=userBuilder.password;
        this.movieList=userBuilder.movieList;
        this.tvShowsList=userBuilder.tvShowsList;
    }


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

    public static class UserBuilder{


        private String name;
        private String surname;
        private int age;
        private String password;
        private String email;
        private List<Movie> movieList;
        private List<TvShows> tvShowsList;



        public UserBuilder withName(String name){
            this.name=name;
            return this;
        }

        public UserBuilder withAge(int age){
            this.age=age;
            return this;
        }

        public UserBuilder withPassword(String password){
            this.password=password;
            return this;
        }

        public UserBuilder withEmail(String email){
            this.email=email;
            return this;
        }

        public UserBuilder withMovies(List<Movie>movieList){
            this.movieList=movieList;
            return this;
        }

        public UserBuilder withTvShows(List<TvShows>tvShowsList){
            this.tvShowsList=tvShowsList;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
