package com.example.backend.services;

import com.example.backend.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {

    MovieResponse saveMovieFromTmdb(Long Tmdb);

    MovieResponse getMovieById(Long id);
}
