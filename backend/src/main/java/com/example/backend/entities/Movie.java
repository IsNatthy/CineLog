package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long Id;

    //External API id
    @Column(name = "tmdb_id")
    private Long tmdbId;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "posterPath")
    private String posterPath;

    @Column(name = "overview", length = 500)
    private String overview;

    @Column(name = "first_added_at", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime firstAddedAt;
}
