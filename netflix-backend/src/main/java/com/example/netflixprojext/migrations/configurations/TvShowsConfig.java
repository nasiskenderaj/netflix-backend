package com.example.netflixprojext.migrations.configurations;

import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.repository.CategoryRepository;
import com.example.netflixprojext.repository.MovieRepository;
import com.example.netflixprojext.repository.TvShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TvShowsConfig implements CommandLineRunner {

    @Autowired
    private TvShowsRepository tvShowsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        TvShows tvShow1=new TvShows("Game Of Thrones",90,10,"In the Game of Thrones, you either win or you die. In the mythical continent of Westeros...","https://www.youtube.com/watch?v=KPLWWIOCOOQ",73,"kwf0kw");
        TvShows tvShow2=new TvShows("Money Heist",80,20,"In the Game of Thrones, you either win or you die. In the mythical continent of Westeros...","https://www.youtube.com/watch?v=KPLWWIOCOOQ",73,"kwf0kw");

//        tvShow1.setCategory(categoryRepository.getReferenceById(1L));
        tvShowsRepository.save(tvShow1);
        tvShowsRepository.save(tvShow2);
    }
}
