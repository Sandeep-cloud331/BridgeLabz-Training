package com.example.fundoo_notes.batch;

import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.repository.NoteRepository;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class NoteImportWriter
        implements ItemWriter<Note> {
    private final NoteRepository noteRepository;
    public NoteImportWriter(
            NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @Override
    public void write(
            Chunk<? extends Note> chunk)
            throws Exception {
        noteRepository.saveAll(
                chunk.getItems());
    }
}
