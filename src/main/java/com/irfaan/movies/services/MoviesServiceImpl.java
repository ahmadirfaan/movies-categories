package com.irfaan.movies.services;


import com.irfaan.movies.entities.Movies;
import com.irfaan.movies.models.ResponseWebMovies;
import com.irfaan.movies.repositories.CategoryRepository;
import com.irfaan.movies.repositories.MoviesRepository;
import com.irfaan.movies.repositories.RelMoviesDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private RelMoviesDetailRepository relMoviesDetailRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseWebMovies getMoviesById(Integer id) {
        Optional<Movies> movies = moviesRepository.findById(id);
        if(!movies.isPresent()) {
            return null;
        } else {
            ResponseWebMovies responseWebMovies = new ResponseWebMovies();

            return responseWebMovies;

        }
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
    public void sortingMovies(List<ResponseWebMovies> data, String sortMovies) {

    }
}
