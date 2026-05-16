package com.example.backend.controller;

import com.example.backend.dto.response.MovieResponse;
import com.example.backend.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/sync/{tmdbId}")
    public ResponseEntity<MovieResponse> syncMovies(@PathVariable("tmdbId") Long tmdbId){
        return ResponseEntity.ok(movieService.saveMovieFromTmdb(tmdbId));
    }

}
