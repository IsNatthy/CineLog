package com.example.backend.repositories;

import com.example.backend.entities.Media;
import com.example.backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media,Long> {

    Optional<Media> findByTmbdId(Long tmbdId);

}
