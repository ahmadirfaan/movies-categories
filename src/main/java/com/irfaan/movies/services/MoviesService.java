package com.irfaan.movies.services;

import com.irfaan.movies.models.ResponseWebMovies;

import java.util.List;

public interface MoviesService {

    ResponseWebMovies getMoviesById(Integer id);

    List<ResponseWebMovies> getAllMovies();

    List<ResponseWebMovies> getMoviesByCategory(String categoryName);

    List<ResponseWebMovies> getNewMovies();

    void sortingMovies(String sortMovies);
}
