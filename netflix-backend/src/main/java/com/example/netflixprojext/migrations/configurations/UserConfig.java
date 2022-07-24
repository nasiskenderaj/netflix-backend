package com.example.netflixprojext.migrations.configurations;

import com.example.netflixprojext.entities.Movie;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.TvShows;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.MovieRepository;
import com.example.netflixprojext.repository.RoleRepository;
import com.example.netflixprojext.repository.TvShowsRepository;
import com.example.netflixprojext.repository.UserRepository;
import com.example.netflixprojext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TvShowsRepository tvShowsRepository;


    @Override
    public void run(String... args) throws Exception {

//        userService.saveRole(new Role(1L,"ROLE_USER"));
//        userService.saveRole(new Role(2l,"ROLE_MANAGER"));
//        userService.saveRole(new Role(3l,"ROLE_ADMIN"));
//        userService.saveRole(new Role(4l,"ROLE_USER"));
//
//        userService.saveUser(new User.UserBuilder().withName("Denis")
//                .withAge(23)
//                .withName("denis")
//                .withEmail("denis958@gmail.com")
//                .withPassword("denis12345")
//                .withRoles(new ArrayList<>())
//                .build());
//
//        userService.saveUser(new User.UserBuilder()
//                .withName("Nasibi")
//                .withAge(25)
//                .withEmail("nasibi958@gmail.com")
//                .withPassword("nasibi12345")
//                .withMovies(List.of(new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","modscom")))
//                .withRoles(new ArrayList<>())
//                .build());
//
//        userService.addRoleToUser("denis958@gmail.com","ROLE_ADMIN");
//        userService.addRoleToUser("denis958@gmail.com","ROLE_USER");
//        userService.addRoleToUser("denis958@gmail.com","ROLE_MANAGER");
//        userService.addRoleToUser("nasibi958@gmail.com","ROLE_USER");




        Role role1=new Role(1L,"ROLE_USER");
        Role role2=new Role(2L,"ROLE_ADMIN");

        roleRepository.save(role1);
        roleRepository.save(role2);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user1=new User.UserBuilder()
                .withName("Denis")
                .withAge(23)
                .withEmail("denis958@gmail.com")
                .withPassword(encoder.encode("denis12345"))
                .withRoles(List.of(role1))
                .build();

        User user2=new User.UserBuilder()
                .withName("Nasibi")
                .withAge(25)
                .withEmail("nasibi958@gmail.com")
                .withPassword(encoder.encode("nasibi12345"))
                .withMovies(List.of(new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","modscom")))
                .withRoles(List.of(role2))
                .build();




//        User user1=new User.UserBuilder()
//                .withName("Denis")
//                .withAge(23)
//                .withEmail("denis958@gmail.com")
//                .withPassword("denis12345")
//                .build();
//
//        User user2=new User.UserBuilder()
//                .withName("Nasibi")
//                .withAge(25)
//                .withEmail("nasibi958@gmail.com")
//                .withPassword("nasibi12345")
//                .withMovies(List.of(new Movie("Avengers Endgame", 2.26, 5.99, "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...", "https://www.youtube.com/watch?v=TcMBFSGVi1c","modscom")))
//                .build();



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
