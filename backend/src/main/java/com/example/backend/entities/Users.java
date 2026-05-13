package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname",  nullable = false)
    private String surname;
    @Column(name = "email",  nullable = false, unique  = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;
    @Transient
    private String confirmPassword;

    @Column(name = "birthday",  nullable = false)
    private LocalDate birthday;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "modifiedAt")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<DiaryEntry> diaryEntries;
}
