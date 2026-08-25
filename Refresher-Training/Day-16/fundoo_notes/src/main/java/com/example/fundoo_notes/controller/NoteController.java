package com.example.fundoo_notes.controller;

import com.example.fundoo_notes.dto.noteDTO.NoteRequestDTO;
import com.example.fundoo_notes.entity.Note;
import com.example.fundoo_notes.service.NoteExportService;
import com.example.fundoo_notes.service.NoteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
@SecurityRequirement(name = "bearerAuth")
public class NoteController {
    private final NoteService noteService;
    private final NoteExportService noteExportService;

    public NoteController(
            NoteService noteService, NoteExportService noteExportService) {
        this.noteService = noteService;
        this.noteExportService = noteExportService;
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
            @RequestBody NoteRequestDTO body) {
        Note note = noteService.createNote(
                currentUserId(),
                body.getTitle(),
                body.getDescription());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(note);
    }

    @PostMapping("/{id}/reminder")
    public ResponseEntity<Note> setReminder(@PathVariable int id, @RequestBody LocalDateTime reminderAt){
        noteService.setReminder(id, reminderAt);

        return ResponseEntity.ok().build();
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

    //5thunpin

    //6th
    @GetMapping("/notes/export")
    public ResponseEntity<byte[]> exportNotes()
            throws Exception {
        List<Note> notes =
                noteService.findActiveByOwner(
                        currentUserId());
        byte[] excelBytes =
                noteExportService.exportToExcel(
                        notes);
        return ResponseEntity.ok()
                .header(
                        "Content-Disposition",
                        "attachment; " +
                                "filename=my-notes.xlsx")
                .contentType(
                        MediaType.APPLICATION_OCTET_STREAM)
                .body(excelBytes);
    }

}
