package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id",   nullable = false)
    private Long Id;

    //External API id
    @Column(name = "tmbd_id", unique = true)
    private Long tmbdId;

    @Column(name = "title")
    private String title;
    @Column(name = "posterPath")
    private String posterPath;
}
