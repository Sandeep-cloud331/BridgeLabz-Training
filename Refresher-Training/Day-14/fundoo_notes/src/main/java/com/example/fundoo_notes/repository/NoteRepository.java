package com.example.fundoo_notes.repository;

import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository
        extends JpaRepository<Note, Integer> {
    List<Note> findByOwner(User owner);
    Optional<Note> findByNoteIdAndOwner(
            int noteId,
            User owner);
}
