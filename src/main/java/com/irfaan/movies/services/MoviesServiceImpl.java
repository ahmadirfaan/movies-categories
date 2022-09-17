package com.irfaan.movies.services;


import com.irfaan.movies.entities.Movies;
import com.irfaan.movies.entities.MoviesDetail;
import com.irfaan.movies.entities.RelMoviesDetail;
import com.irfaan.movies.enums.SortEnum;
import com.irfaan.movies.models.ResponseWebMovies;
import com.irfaan.movies.repositories.MoviesRepository;
import com.irfaan.movies.repositories.RelMoviesDetailRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private RelMoviesDetailRepository relMoviesDetailRepository;


    @Override
    public ResponseWebMovies getMoviesById(Integer id) {
        Optional<Movies> movies = moviesRepository.findById(id);
        if (!movies.isPresent()) {
            return null;
        } else {
            Movies dataMovies = movies.get();
            RelMoviesDetail relMoviesDetail = relMoviesDetailRepository.findAllByMoviesId(dataMovies.getId());
            return convertToResponse(relMoviesDetail);

        }
    }

    public List<ResponseWebMovies> getAllMovies() {
        List<RelMoviesDetail> allMoviesDetails = relMoviesDetailRepository.findAll();
        return allMoviesDetails.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    public List<ResponseWebMovies> getMoviesByCategory(String categoryName) {
        List<ResponseWebMovies> allMovies = getAllMovies();
        return allMovies.stream()
                .filter(relMoviesDetail -> relMoviesDetail.getCategory().equals(categoryName))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseWebMovies> getMoviesList(String sortMovies, String category) {
        List<ResponseWebMovies> data = new ArrayList<>();
        if (StringUtils.isBlank(category) && StringUtils.isBlank(sortMovies)) {
            data = getAllMovies();
        }

        if (!StringUtils.isBlank(category)) {
            data = getMoviesByCategory(category);
        }
        SortEnum sortEnum = SortEnum.getByCode(sortMovies);
        if (!StringUtils.isBlank(sortMovies) && sortEnum != null) {
            data.sort(compareByYear());
            if (SortEnum.OLDEST_MOVIES == sortEnum) {
                Collections.reverse(data);
            }
        }

        return data;

    }

    private Comparator<ResponseWebMovies> compareByYear() {
        return (o1, o2) -> {
            int releaseYearO1 = Integer.parseInt(o1.getReleaseYear());
            int releaseYearO2 = Integer.parseInt(o2.getReleaseYear());
            if (releaseYearO1 == releaseYearO2)
                return 0;
            return releaseYearO1 < releaseYearO2 ? -1 : 1;
        };
    }


    private ResponseWebMovies convertToResponse(RelMoviesDetail almv) {
        ResponseWebMovies responseWebMovies = new ResponseWebMovies();

        Movies m = almv.getMovies();
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
