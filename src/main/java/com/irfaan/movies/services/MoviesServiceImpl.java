package com.irfaan.movies.services;


import com.irfaan.movies.models.ResponseWebMovies;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MoviesServiceImpl implements MoviesService {

    @Override
    public ResponseWebMovies getMoviesById(Integer id) {
        return null;
    }

    @Override
    public List<ResponseWebMovies> getAllMovies() {
        return null;
    }

    @Override
    public List<ResponseWebMovies> getMoviesByCategory(String categoryName) {
        return null;
    }

    @Override
    public List<ResponseWebMovies> getNewMovies() {
        return null;
    }

    @Override
    public void sortingMovies(String sortMovies) {

    }
}
