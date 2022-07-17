package com.example.netflixprojext.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TvShows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double duration;
    private double price;
    private String description;
    private String url;
    private int noOfEpisodes;
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "tvShows_user",
            joinColumns = @JoinColumn(name = "tvShows_id")
            ,inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList;


    public TvShows(String title, double duration, double price, String description, String url, int noOfEpisodes,String imageUrl) {
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.url = url;
        this.noOfEpisodes = noOfEpisodes;
        this.imageUrl=imageUrl;

    }

    public TvShows() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNoOfEpisodes() {
        return noOfEpisodes;
    }

    public void setNoOfEpisodes(int noOfEpisodes) {
        this.noOfEpisodes = noOfEpisodes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
