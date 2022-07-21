package com.example.netflixprojext.repository;

import com.example.netflixprojext.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Override
    Optional<Movie> findById(Long aLong);

    Optional<Movie> findByTitle(String title);
}
