package com.example.backend.entities;

import jakarta.persistence.*;

@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tmbd_id", unique = true)
    private Long tmbdId;

    @Column(name = "title")
    private String title;
}
