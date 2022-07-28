package com.example.netflixprojext.dto;

import lombok.Data;

@Data
public class TvShowsDTO {

    private Long id;
    private String title;
    private double duration;
    private double price;
    private String description;
    private String url;
    private int noOfEpisodes;
    private String imageUrl;


}
