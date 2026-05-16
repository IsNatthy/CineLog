package com.example.backend.repositories;

import com.example.backend.entities.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepository extends JpaRepository<UserMovie,Long> {
}
