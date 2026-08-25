package com.example.fundoo_notes.dto.imprt;


import lombok.Data;

@Data
public class NoteImportRow {
    private String title;
    private String content;
    private int userId;
    // getters and setters
}
