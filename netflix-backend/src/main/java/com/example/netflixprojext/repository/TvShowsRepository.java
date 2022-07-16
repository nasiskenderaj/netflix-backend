package com.example.netflixprojext.repository;

import com.example.netflixprojext.entities.TvShows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowsRepository extends JpaRepository<TvShows,Long> {
}
