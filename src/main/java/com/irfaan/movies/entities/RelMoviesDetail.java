package com.irfaan.movies.entities;

import javax.persistence.*;

public class RelMoviesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movies_id", nullable = false)
    private Movies movies;

    @ManyToOne
    @JoinColumn(name = "movies_detail_id", nullable = false)
    private MoviesDetail moviesDetail;
}
