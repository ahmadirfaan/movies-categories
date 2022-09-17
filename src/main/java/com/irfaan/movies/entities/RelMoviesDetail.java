package com.irfaan.movies.entities;

import javax.persistence.*;

public class RelMoviesDetail extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movies_id", nullable = false)
    private Movies movies;

    @ManyToOne
    @JoinColumn(name = "movies_detail_id", nullable = false)
    private MoviesDetail moviesDetail;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public MoviesDetail getMoviesDetail() {
        return moviesDetail;
    }

    public void setMoviesDetail(MoviesDetail moviesDetail) {
        this.moviesDetail = moviesDetail;
    }

    @Override
    public String toString() {
        return "RelMoviesDetail{" +
                "id=" + id +
                ", movies=" + movies +
                ", moviesDetail=" + moviesDetail +
                '}';
    }
}
