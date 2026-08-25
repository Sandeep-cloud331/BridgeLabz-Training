package com.example.fundoo_notes.service;

import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.entity.Tag;
import com.example.fundoo_notes.entity.User;
import com.example.fundoo_notes.messaging.ReminderProducer;
import com.example.fundoo_notes.repository.NoteRepository;
import com.example.fundoo_notes.repository.TagRepository;
import com.example.fundoo_notes.repository.UserRepository;
import com.example.fundoo_notes.repository.impl.NoteSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final ReminderProducer reminderProducer;

    public NoteService(
            NoteRepository noteRepository,
            UserRepository userRepository, TagRepository tagRepository, ReminderProducer reminderPro) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.tagRepository  = tagRepository;
        this.reminderProducer = reminderPro;
    }

    //method: createNote
    public Note createNote(
            int userId,
            String title,
            String content) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"));
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setOwner(owner);
        return noteRepository.save(note);
    }

    //method: getNotesByOwner
    public List<Note> findByOwner(int userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"));
        return noteRepository.findByOwner(owner);
    }

    //method: deleteNote
    public boolean deleteNote(
            int noteId,
            int UserId) {
        User owner = userRepository
                .findById(UserId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"));
        return noteRepository
                .findByNoteIdAndOwner(noteId, owner)
                .map(note -> {
                    noteRepository.delete(note);
                    return true;
                })
                .orElse(false);
    }

    //method: archiveNote
    public Note archiveNote(
            int noteId,
            int userId) {
        Note note =
                getOwnedNoteOrThrow(noteId, userId);
        note.setState(
                Note.NoteState.ARCHIVED);
        note.setPinned(false);
        return noteRepository.save(note);
    }

    //method: trashNote
    public Note trashNote(
            int noteId,
            int userId) {
        Note note =
                getOwnedNoteOrThrow(noteId, userId);
        note.setState(
                Note.NoteState.TRASHED);
        note.setPinned(false);
        return noteRepository.save(note);
    }

    //method: restoreNote
    public Note restoreNote(
            int noteId,
            int userId) {
        Note note =
                getOwnedNoteOrThrow(noteId, userId);
        note.setState(
                Note.NoteState.ACTIVE);
        return noteRepository.save(note);
    }

    //method: pinNote
    public Note pinNote(
            int noteId,
            int userId) {
        Note note =
                getOwnedNoteOrThrow(noteId, userId);
        if (note.getState() ==
                Note.NoteState.TRASHED) {
            throw new IllegalStateException(
                    "Cannot pin a note that is in Trash");
        }
        note.setPinned(true);
        return noteRepository.save(note);
    }

    //utility-method: to get note by id and owner
    private Note getOwnedNoteOrThrow(
            int noteId,
            int userId) {
        User owner =
                userRepository.findById(userId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "User not found"));
        return noteRepository
                .findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Note not found"));
    }

    public List<Note> findByOwnerAndState(int userId, Note.NoteState noteState) {
        return noteRepository.findByOwnerAndState(userRepository.findById(userId).orElseThrow(), noteState);
    }

    public List<Note> findPinnedByOwner(int userId) {
        return noteRepository.findByOwnerAndPinnedTrueAndStateNot(userRepository.findById(userId).orElseThrow(), Note.NoteState.TRASHED);
    }

    public List<Note> findActiveByOwner(int userId) {
        return noteRepository.findByOwnerAndState(userRepository.findById(userId).orElseThrow(), Note.NoteState.ACTIVE);
    }
    public List<Note> search(
            int userId,
            String titleText,
            Note.NoteState state,
            String tagName) {
        User owner = userRepository.findById(userId).orElseThrow();
        Specification<Note> spec = NoteSpecifications.search(owner, titleText, state,tagName);
        return noteRepository.findAll(spec);
    }

    public Note addTagToNote(int noteId, int userId, String tagName) {
        Note note = getOwnedNoteOrThrow(noteId, userId);
        Tag tag = tagRepository.findByName(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
        note.getTags().add(tag);
        return noteRepository.save(note);
    }
    public List<Note> findByOwnerAndTag(int userId, String tagName) {
        User owner =
                userRepository.findById(userId).orElseThrow();
        return noteRepository.findByOwnerAndTagsName(owner, tagName);
    }

    public void setReminder(int noteId, LocalDateTime reminderAt) {
        System.out.println("🔥 SET REMINDER CALLED");
        Note note = noteRepository.findById(noteId).orElseThrow(()->new RuntimeException("Note not found"));
        note.setReminderAt(reminderAt);
        noteRepository.save(note);
        System.out.println("🔥 Calling reminder producer");
        reminderProducer.sendReminderRequest(noteId,reminderAt);
        System.out.println("🔥 Reminder producer finished");

    }
}
