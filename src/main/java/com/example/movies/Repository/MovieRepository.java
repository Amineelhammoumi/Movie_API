package com.example.movies.Repository;


import com.example.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenreOrderByReleaseYearDesc(String genre);
}