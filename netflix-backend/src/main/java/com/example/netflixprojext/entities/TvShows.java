package com.example.netflixprojext.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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


}
