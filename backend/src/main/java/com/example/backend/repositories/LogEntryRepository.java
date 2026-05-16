package com.example.backend.repositories;

import com.example.backend.entities.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntryRepository extends JpaRepository<LogEntry,Long> {
}
