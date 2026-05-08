package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "diary_entries")
@Getter
@Setter
@NoArgsConstructor
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
