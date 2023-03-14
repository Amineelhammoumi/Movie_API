package com.example.movies.service;

import com.example.movies.Repository.MovieRepository;
import com.example.movies.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImplimentation implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    RestTemplate restTemplate ;


    @Override
    public List<Movie> getRecommendationsByGenre(String genre) {
        ArrayList<Movie> recommendations = new ArrayList<>();


        Movie[] movies =  restTemplate.getForObject("http://localhost:8080/api/movies" ,  Movie[].class);

        assert movies != null;
        return  Arrays.stream(movies).toList().stream().filter(movie -> movie.getGenre().equals(genre))
                .sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
                .collect(Collectors.toList());

    }

//    public List<Movie> getRecommendationsByGenre(String genre) {
//        return movieRepository.findByGenreOrderByReleaseYearDesc(genre);
//    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


}
