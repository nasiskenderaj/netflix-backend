package com.example.netflixprojext.migrations.configurations;

import com.example.netflixprojext.entities.Category;
import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.repository.CategoryRepository;
import com.example.netflixprojext.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","modscom");
        Movie movie2 = new Movie("Avengers Infinity War", 2.25, 5.99, "A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality.", "https://www.youtube.com/watch?v=6ZfuNTqbHE8","oksdp");
        Movie movie3 = new Movie("Titanic", 2.11, 3.99, "The movie is about the 1912 sinking of the RMS Titanic.", "https://www.youtube.com/watch?v=kVrqfYjkTdQ","kpwkpw");
        Movie movie4 = new Movie("Despicable me", 3.00, 7.99, "When a criminal mastermind uses a trio of orphan girls as pawns for a grand scheme, he finds their love is profoundly changing him for the better. ", "https://www.youtube.com/watch?v=sUkZFetWYY0","pwmkdpkwd");

//        Category category1 = new Category("action");
//        Category category2 = new Category("romance");
//        Category category3 = new Category("animation");
//        Category category4 = new Category("horror");
//
//        categoryRepository.saveAll(List.of(category1, category2, category3, category4));
//        movie1.setCategory(category1);
//        movie2.setCategory(category1);
//        movie3.setCategory(category2);
//        movie4.setCategory(category3);

        movie1.setCategory(categoryRepository.getReferenceById(1L));
        movie2.setCategory(categoryRepository.getReferenceById(1L));
        movie3.setCategory(categoryRepository.getReferenceById(2L));
        movie4.setCategory(categoryRepository.getReferenceById(3L));
        movieRepository.saveAll(
                List.of(movie1, movie2, movie3, movie4));
    }
}
