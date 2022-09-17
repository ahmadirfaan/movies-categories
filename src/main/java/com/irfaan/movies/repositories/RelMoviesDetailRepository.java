package com.irfaan.movies.repositories;

import com.irfaan.movies.entities.RelMoviesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelMoviesDetailRepository extends JpaRepository<RelMoviesDetail, Integer> {

    @Query(value = "SELECT * FROM rel_movies_detail WHERE movies_id = ?1", nativeQuery = true)
    List<RelMoviesDetail> findAllByMoviesId(String moviesId);
}
