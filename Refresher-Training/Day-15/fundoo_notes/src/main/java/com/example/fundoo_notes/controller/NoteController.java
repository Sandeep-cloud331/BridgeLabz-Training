package com.example.fundoo_notes.controller;

import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.service.NoteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
@SecurityRequirement(name = "bearerAuth")
public class NoteController {
    private final NoteService noteService;
    public NoteController(
            NoteService noteService) {
        this.noteService = noteService;
    }

    //utility method to get current user id
    private int currentUserId() {
        String userId =
                (String) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();
        return Integer.parseInt(userId);
    }

    //method: createNote
    @PostMapping
    public ResponseEntity<Note> createNote(
            @RequestBody Map<String, String> body) {
        Note note = noteService.createNote(
                currentUserId(),
                body.get("title"),
                body.get("content"));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(note);
    }

    //method: getMyNotes
//    @GetMapping
//    public List<Note> getMyNotes() {
//        return noteService.findByOwner(
//                currentUserId());
//    }

    //method: deleteNote
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(
            @PathVariable int id) {
        boolean deleted =
                noteService.deleteNote(
                        id,
                        currentUserId());
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    //??why state>pinned (if both params are present)
    @GetMapping
    public List<Note> getNotes(
            @RequestParam(
                    required = false) String state,
            @RequestParam(
                    required = false) Boolean pinned) {
        int userId = currentUserId();
        if (state != null) {
            return noteService
                    .findByOwnerAndState(
                            userId,
                            Note.NoteState.valueOf(
                                    state.toUpperCase()));
        }
        if (pinned != null && pinned) {
            return noteService
                    .findPinnedByOwner(userId);
        }
        return noteService
                .findActiveByOwner(userId);
    }

    //patch methods: archive, trash, restore, pin
    //1st:Archive
    @PatchMapping("/{id}/archive")
    public ResponseEntity<Note> archiveNote(
            @PathVariable int id) {
        return ResponseEntity.ok(
                noteService.archiveNote(
                        id, currentUserId()));
    }

    //2nd:Trash
    @PatchMapping("/{id}/trash")
    public ResponseEntity<Note> trashNote(
            @PathVariable int id) {
        return ResponseEntity.ok(
                noteService.trashNote(
                        id, currentUserId()));
    }

    //3rd:Restore
    @PatchMapping("/{id}/restore")
    public ResponseEntity<Note> restoreNote(
            @PathVariable int id) {
        return ResponseEntity.ok(
                noteService.restoreNote(
                        id, currentUserId()));
    }

    //4th:Pin
    @PatchMapping("/{id}/pin")
    public ResponseEntity<Note> pinNote(
            @PathVariable int id) {
        return ResponseEntity.ok(
                noteService.pinNote(
                        id, currentUserId()));
    }

}
