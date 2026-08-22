package com.example.fundoo_notes.controller;

import com.example.fundoo_notes.dto.AuthResponseDTO;
import com.example.fundoo_notes.dto.LoginRequestDTO;
import com.example.fundoo_notes.dto.RegisterRequestDTO;
import com.example.fundoo_notes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        System.out.println("hello req reached controller");
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
}
