package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname",  nullable = false)
    private String surname;
    @Column(name = "email",  nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "birthday",  nullable = false)
    private LocalDate birthday;

    @Column(name = "createdAt", nullable = false)
    private LocalDate createdAt;
    @Column(name = "modifiedAt")
    private LocalDate modifiedAt;
}
