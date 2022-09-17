package com.irfaan.movies.services;


import com.irfaan.movies.entities.Movies;
import com.irfaan.movies.entities.MoviesDetail;
import com.irfaan.movies.entities.RelMoviesDetail;
import com.irfaan.movies.models.ResponseWebMovies;
import com.irfaan.movies.repositories.CategoryRepository;
import com.irfaan.movies.repositories.MoviesRepository;
import com.irfaan.movies.repositories.RelMoviesDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            Movies dataMovies = movies.get();
            RelMoviesDetail relMoviesDetail = relMoviesDetailRepository.findAllByMoviesId(dataMovies.getId());
            ResponseWebMovies responseWebMovies = convertToResponse(dataMovies, relMoviesDetail);
            return responseWebMovies;

        }
    }

    @Override
    public List<ResponseWebMovies> getAllMovies() {
        List<Movies> allMovies = moviesRepository.findAll();
        List<RelMoviesDetail> allMoviesDetails = relMoviesDetailRepository.findAll();
        List<ResponseWebMovies> allResponse = new ArrayList<>();
        if(!allMovies.isEmpty()) {
            allMovies.forEach(m -> {

                allMoviesDetails.forEach(almv -> {
                    if(almv.getMovies().getId().equals(m.getId())) {
                        ResponseWebMovies responseWebMovies = convertToResponse(m, almv);
                        allResponse.add(responseWebMovies);
                    }

                });
            });
        }
        return allResponse;
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


    private ResponseWebMovies convertToResponse(Movies m, RelMoviesDetail almv) {
        ResponseWebMovies responseWebMovies = new ResponseWebMovies();
        responseWebMovies.setCategory(m.getCategory().getName());
        responseWebMovies.setTitle(m.getTitle());
        responseWebMovies.setReleaseYear(m.getReleaseYear());
        MoviesDetail moviesDetail = almv.getMoviesDetail();
        responseWebMovies.setDownloadable(moviesDetail.isDownloadable());
        responseWebMovies.setShareable(moviesDetail.isShareAble());
        responseWebMovies.setRating(String.valueOf(moviesDetail.getRating()));
        responseWebMovies.setDescription(moviesDetail.getDetailDescription());
        return responseWebMovies;
    }
}
