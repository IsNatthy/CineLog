package com.example.backend.clientAPI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tmdb-client", url = "${tmdb.base.url}")
public interface TmdbClient {

    @GetMapping("/search/movie")
    String searchMovie(@RequestParam("query") String query);

    @GetMapping("/movie/{tmdb_id}}")
    String getMovieDetails(@PathVariable("tmdb_id") Long tmdbId);

}
