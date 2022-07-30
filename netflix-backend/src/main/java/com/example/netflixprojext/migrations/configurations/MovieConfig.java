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
        Category category1 = new Category("action");
        Category category2 = new Category("romance");
        Category category3 = new Category("comedy");


        categoryRepository.saveAll(List.of(category1, category2, category3));


        Movie movie1 = new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_.jpg",category1);

        Movie movie2 = new Movie("Avengers Infinity War", 2.25, 5.99, "A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality.", "https://www.youtube.com/watch?v=6ZfuNTqbHE8","https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_.jpg",category1);
        Movie movie3 = new Movie("The Batman", 2.11, 8.99, "Batman was originally introduced as a ruthless vigilante who frequently killed or maimed criminals, but evolved into a character with a stringent moral code and strong sense of justice. ", "https://www.youtube.com/watch?v=mqqft2x_Aa4","https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_.jpg",category1);
        Movie movie4 = new Movie("Tomb Raider", 90, 7.99, "Tomb Raider explores the intense and gritty origin story of Lara Croft and her ascent from a young woman to a hardened survivor ", "https://www.youtube.com/watch?v=8ndhidEmUbI","https://upload.wikimedia.org/wikipedia/en/b/bd/Tomb_Raider_%282018_film%29.png",category1);

        Movie movie5 = new Movie("365 Days: This Day", 3.00, 5.99, "365 Days: This Day (Polish: 365 Dni: Ten Dzień) is a 2022 erotic thriller film directed by Barbara Białowąs and Tomasz Mandes. ", "https://www.youtube.com/watch?v=6k-sIXzaJUY","https://m.media-amazon.com/images/M/MV5BMDdhYzNkOWQtYWNlNi00NDdjLWJlZDMtMjJjZDYyNjAxM2U1XkEyXkFqcGdeQXVyMTQyMTMwOTk0._V1_.jpg",category2);
        Movie movie6 = new Movie("Titanic", 2.11, 3.99, "The movie is about the 1912 sinking of the RMS Titanic.", "https://www.youtube.com/watch?v=kVrqfYjkTdQ","https://www.themoviedb.org/t/p/w500/1kLYRzVj6byWvFa3SLrAOcfgnfp.jpg",category2);
        Movie movie7 = new Movie("A Perfect Pairing", 3.00, 11.99, "The Netflix original film “A Perfect Pairing” is a hot and bawdy journey through Australian culture, lush pastures... ", "https://www.youtube.com/watch?v=WR21TH-6LfY","https://upload.wikimedia.org/wikipedia/en/thumb/2/2a/A_Perfect_Pairing_film_poster.jpg/220px-A_Perfect_Pairing_film_poster.jpg",category2);
        Movie movie8 = new Movie("Through My Window", 3.00, 5.99, " Raquel's longtime crush on her next-door neighbor turns into something more when he starts developing feelings for her, despite his family's objections. ", "https://www.youtube.com/watch?v=_zxhK3Z-R0c","https://upload.wikimedia.org/wikipedia/en/d/d5/Through_My_Window_film_poster.png",category2);

        Movie movie9 = new Movie("Get Smart", 3.00, 3.99, " Get Smart is an American comedy television series, parodying the secret agent genre that had become widely popular in the first half of the 1960s with the release of James Bond films. ", "https://www.youtube.com/watch?v=K9WNBO3szgQ","https://upload.wikimedia.org/wikipedia/en/8/88/Getsmart08.png",category3);
        Movie movie10 = new Movie("Keeping Up With the Joneses", 3.00, 8.99, "informal + often disapproving. : to show that one is as good as other people by getting what they have and doing what they do people trying to keep up with the Joneses by buying expensive cars and clothes that they can't afford. ", "https://www.youtube.com/watch?v=nPfYXXg65qA","https://m.media-amazon.com/images/M/MV5BYzE3ZmVmNWUtNTE1ZS00ODgzLWI0MDQtYjY0Njc4ZGZmNjc1XkEyXkFqcGdeQXVyMTU0NjY0NDg@._V1_.jpg",category3);
        Movie movie11= new Movie("Cruella", 45.00, 12.99, "Cruella, which is set in 1970s London amidst the punk rock revolution, follows a young grifter named Estella, a clever and creative girl determined to make a name for herself with her designs. ", "https://www.youtube.com/watch?v=gmRKv7n2If8","https://m.media-amazon.com/images/M/MV5BOWI5YTUxOWEtZmRiZS00ZmQxLWE2NzctYTRiODA2NzE1ZjczXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg",category3);
        Movie movie12= new Movie("Despicable me", 3.00, 7.99, "When a criminal mastermind uses a trio of orphan girls as pawns for a grand scheme, he finds their love is profoundly changing him for the better. ", "https://www.youtube.com/watch?v=sUkZFetWYY0","https://m.media-amazon.com/images/M/MV5BMTY3NjY0MTQ0Nl5BMl5BanBnXkFtZTcwMzQ2MTc0Mw@@._V1_.jpg",category3);

        categoryRepository.saveAll(List.of(category1, category2, category3));
//        movie1.setCategory(category1);
//        movie2.setCategory(category1);
//        movie3.setCategory(category2);
//        movie4.setCategory(category3);

//        movie1.setCategory(categoryRepository.getReferenceById(1L));
//        movie2.setCategory(categoryRepository.getReferenceById(1L));
//        movie3.setCategory(categoryRepository.getReferenceById(2L));
//        movie4.setCategory(categoryRepository.getReferenceById(3L));
        movieRepository.saveAll(
                List.of(movie1, movie2, movie3, movie4,movie5,movie6,movie7,movie8,movie9,movie10,movie11,movie12));
    }
}
