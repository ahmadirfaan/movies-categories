package com.irfaan.movies.services;

import com.irfaan.movies.models.ResponseWebMovies;

import java.util.List;

public interface MoviesService {

    ResponseWebMovies getMoviesById(Integer id);

    List<ResponseWebMovies> getMoviesList(String sortMovies, String category);
}
