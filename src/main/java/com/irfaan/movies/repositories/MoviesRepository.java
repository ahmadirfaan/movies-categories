package com.irfaan.movies.repositories;

import com.irfaan.movies.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}
