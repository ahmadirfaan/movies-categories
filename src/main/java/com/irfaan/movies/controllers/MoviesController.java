package com.irfaan.movies.controllers;


import com.irfaan.movies.models.ResponseMessage;
import com.irfaan.movies.models.ResponseWebMovies;
import com.irfaan.movies.services.MoviesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/movies")
@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping()
    public ResponseEntity<Object> findAll(
            @RequestParam String category, @RequestParam String sortMovies
    ) {
        List<ResponseWebMovies> data = moviesService.getMoviesList(sortMovies, category);
        return ResponseEntity.ok().body(ResponseMessage.success(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable Integer id) {
        ResponseWebMovies movies = moviesService.getMoviesById(id);
        if (movies == null) {
            return ResponseEntity.badRequest().body(ResponseMessage.error(HttpStatus.BAD_REQUEST.value(), "Not found movies"));
        } else {
            return ResponseEntity.ok().body(ResponseMessage.success(movies));
        }
    }


}
