package com.example.netflixprojext.migrations.configurations;

import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.MovieRepository;
import com.example.netflixprojext.repository.TvShowsRepository;
import com.example.netflixprojext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TvShowsRepository tvShowsRepository;


    @Override
    public void run(String... args) throws Exception {
        User user1=new User.UserBuilder()
                .withName("Denis")
                .withAge(23)
                .withEmail("denis958@gmail.com")
                .withPassword("denis12345")
                .build();

        User user2=new User.UserBuilder()
                .withName("Nasibi")
                .withAge(25)
                .withEmail("nasibi958@gmail.com")
                .withPassword("nasibi12345")
                .withMovies(List.of(new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","modscom")))
                .build();



//        user1.setMovieList(Collections.singletonList(movieRepository.getReferenceById(1L)));
//        user1.setMovieList(movieRepository.findAllById(Collections.singleton(2L)));
//        user1.setMovieList(movieRepository.findAllById(Collections.singleton(3L)));

//        user1.setTvShowsList( tvShowsRepository.findAllById(Collections.singleton(1L)));

//        user2.setMovieList(movieRepository.findAllById(Collections.singleton(3L)));
//        user2.setMovieList(movieRepository.findAllById(Collections.singleton(2L)));
//        user2.setTvShowsList( tvShowsRepository.findAllById(Collections.singleton(1L)));
        userRepository.save(user1);
        userRepository.save(user2);


    }
}
