package com.example.fundoo_notes.controller;

import com.example.fundoo_notes.dto.AuthResponseDTO;
import com.example.fundoo_notes.dto.LoginRequestDTO;
import com.example.fundoo_notes.dto.RegisterRequestDTO;
import com.example.fundoo_notes.messaging.ReminderProducer;
import com.example.fundoo_notes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final ReminderProducer reminderProducer;

    public AuthController(UserService userService, ReminderProducer reminderProducer) {

        this.userService = userService;
        this.reminderProducer = reminderProducer;
    }



    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        String token = userService.register(
                request.getEmail(),
                request.getPassword(),
                request.getName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AuthResponseDTO(token));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO request) {
        String token = userService.login(
                request.getEmail(),
                request.getPassword());
        return ResponseEntity.ok(
                new AuthResponseDTO(token));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody Map<String, String> body){
        String email = body.get("email");

        String resetToken = userService.generateResetToken(email);
        reminderProducer.sendPasswordResetRequest(email, resetToken);
        return ResponseEntity.ok().build();
    }


}
