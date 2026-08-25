package com.example.fundoo_notes.dto.noteDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class NoteRequestDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
