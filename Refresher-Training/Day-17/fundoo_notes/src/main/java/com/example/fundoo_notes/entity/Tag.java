package com.example.fundoo_notes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private int tagId;
    @Column(
            nullable = false,
            unique = true)
    private String name;

    public Tag(String tagName) {
    }
}
