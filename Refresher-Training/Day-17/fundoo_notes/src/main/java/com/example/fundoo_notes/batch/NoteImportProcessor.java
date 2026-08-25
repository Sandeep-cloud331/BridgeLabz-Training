package com.example.fundoo_notes.batch;

import com.example.fundoo_notes.dto.imprt.NoteImportRow;
import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.entity.User;
import com.example.fundoo_notes.repository.UserRepository;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NoteImportProcessor
        implements ItemProcessor<
                NoteImportRow, Note> {
    private final UserRepository userRepository;
    public NoteImportProcessor(
            UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Note process(
            NoteImportRow row)
            throws Exception {
        if (row.getTitle() == null ||
                row.getTitle().isBlank()) {
            return null; // skip row
        }
        User owner =
                userRepository.findById(
                                row.getUserId())
                        .orElse(null);
        if (owner == null) {
            return null;
        }
        Note note = new Note();
        note.setTitle(row.getTitle());
        note.setContent(row.getContent());
        note.setOwner(owner);
        return note;
    }
}

