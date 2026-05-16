package com.example.backend.services.servicesImpl;

import com.example.backend.clientAPI.TmdbClient;
import com.example.backend.dto.request.MovieRequest;
import com.example.backend.dto.response.MovieResponse;
import com.example.backend.entities.Movie;
import com.example.backend.mapper.MovieMapper;
import com.example.backend.repositories.MovieRepository;
import com.example.backend.services.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final TmdbClient tmdbClient;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public  MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper, TmdbClient tmdbClient) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.tmdbClient = tmdbClient;
    }

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Override
    public MovieResponse saveMovieFromTmdb(Long tmdbId) {
        return movieRepository.findByTmdbId(tmdbId)
                .map(movieMapper::entityToResponse)
                .orElseGet(() -> {
                    MovieRequest tmdbRequest = tmdbClient.getMovieDetails(tmdbId, apiKey, "es-ES");

                    if (tmdbRequest.getReleaseDate() != null &&  !tmdbRequest.getReleaseDate().isEmpty()) {
                        String yearOnly = tmdbRequest.getReleaseDate().split("-")[0];
                        tmdbRequest.setReleaseDate(yearOnly);
                    }

                    Movie movieEntity = movieMapper.requestToEntity(tmdbRequest);
                    movieEntity.setTmdbId(tmdbId);
                    Movie savedMovie =  movieRepository.save(movieEntity);
                    return movieMapper.entityToResponse(savedMovie);
                });
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie with id " + id + " not found"));
        return movieMapper.entityToResponse(movie);
    }
}
