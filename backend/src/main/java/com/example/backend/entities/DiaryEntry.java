package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "diary_entries")
@Getter
@Setter
@NoArgsConstructor
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id",  nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

    @Column(name = "rating")
    private Double rating;
    @Column(name = "review")
    private String review;

    @Column(name = "watchDate")
    private LocalDate watchDate;
}
