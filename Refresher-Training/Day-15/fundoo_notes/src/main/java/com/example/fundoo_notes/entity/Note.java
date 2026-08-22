package com.example.fundoo_notes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column(nullable = false)
    private  String title;

    @Column(length = 2000)
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User owner;

    public enum NoteState {
        ACTIVE,
        ARCHIVED,
        TRASHED
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NoteState state =
            NoteState.ACTIVE;

    private boolean pinned = false;

    @ManyToMany
    @JoinTable(
            name = "note_tags",
            joinColumns =
            @JoinColumn(name = "note_id"),
            inverseJoinColumns =
            @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();


}
