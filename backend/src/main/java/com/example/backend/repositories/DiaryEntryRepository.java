package com.example.backend.repositories;

import com.example.backend.entities.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry,Long> {
}
