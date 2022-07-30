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
        TvShows tvShow1=new TvShows("Game Of Thrones",90,10,"In the Game of Thrones, you either win or you die. In the mythical continent of Westeros...","https://www.youtube.com/watch?v=KPLWWIOCOOQ",73,"https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg");
        TvShows tvShow2=new TvShows("Money Heist",80,20,"In the Game of Thrones, you either win or you die. In the mythical continent of Westeros...","https://www.youtube.com/watch?v=KPLWWIOCOOQ",73,"https://m.media-amazon.com/images/M/MV5BODI0ZTljYTMtODQ1NC00NmI0LTk1YWUtN2FlNDM1MDExMDlhXkEyXkFqcGdeQXVyMTM0NTUzNDIy._V1_.jpg");
        TvShows tvShow3=new TvShows("Stranger Things",50,40,"After the mysterious and sudden vanishing of a young boy, the people of a small town begin to uncover secrets of a government lab, portals to another world and sinister monsters.","https://www.youtube.com/watch?v=b9EkMc79ZSU",73,"https://m.media-amazon.com/images/M/MV5BMDZkYmVhNjMtNWU4MC00MDQxLWE3MjYtZGMzZWI1ZjhlOWJmXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg");
        TvShows tvShow4=new TvShows("Riverdale",80,20,"Riverdale is the story of a small American town rocked by the murder of a high school student.","https://www.youtube.com/watch?v=HxtLlByaYTc",73,"https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2020%2F05%2F06%2FRVD419b_0576b.jpg&q=60");


//        tvShow1.setCategory(categoryRepository.getReferenceById(1L));
        tvShowsRepository.save(tvShow1);
        tvShowsRepository.save(tvShow2);
        tvShowsRepository.save(tvShow3);
        tvShowsRepository.save(tvShow4);
    }
}
