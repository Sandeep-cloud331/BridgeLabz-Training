package com.example.fundoo_notes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_db")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String name;

    private String resetToken;

    private LocalDateTime resetTokenExpiry;

    @OneToMany(mappedBy = "owner",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Note> notes=
            new ArrayList<>();
}
