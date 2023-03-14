package com.example.movies.service;

import com.example.movies.entity.Movie;

import java.util.List;

public interface MovieService {

    public  List<Movie> getRecommendationsByGenre(String genre);

    public List<Movie> getAllMovies();




}
