package com.example.backend.repositories;

import com.example.backend.entities.DiaryEntry;
import com.example.backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry,Long> {

    Optional<DiaryEntry> findByUserWatchList(Users users);

}
