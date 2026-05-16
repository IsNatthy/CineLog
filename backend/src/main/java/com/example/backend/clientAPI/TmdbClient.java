package com.example.backend.clientAPI;

import com.example.backend.dto.request.MovieRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tmdb-client", url = "${tmdb.base.url}")
public interface TmdbClient {

    @GetMapping("/search/movie")
    String searchMovie(@RequestParam("query") String query,
                       @RequestParam("api_key") String apiKey,
                       @RequestParam("language") String language);

    @GetMapping("/movie/{tmdb_id}")
    MovieRequest getMovieDetails(@PathVariable("tmdb_id") Long tmdbId,
                                 @RequestParam("api_key") String apiKey,
                                 @RequestParam("language") String language);

}
