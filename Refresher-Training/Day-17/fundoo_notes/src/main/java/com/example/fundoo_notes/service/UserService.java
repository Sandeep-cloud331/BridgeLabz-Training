package com.example.fundoo_notes.service;


import com.example.fundoo_notes.entity.User;
import com.example.fundoo_notes.repository.UserRepository;
import com.example.fundoo_notes.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
    //Repository
    private final UserRepository userRepository;

    //Security
    private final JwtUtil jwtUtil;

    //utility
    private final BCryptPasswordEncoder
            passwordEncoder =
            new BCryptPasswordEncoder();


    //Constructor Injection
    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String register(
            String email,
            String password,
            String name) {
        if (userRepository.findByEmail(email)
                .isPresent()) {
            throw new IllegalArgumentException(
                    "Email already registered");
        }
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(
                passwordEncoder.encode(password));
        user.setName(name);
        User saved = userRepository.save(user);
        return jwtUtil.generateToken(
                String.valueOf(saved.getUserId()),
                saved.getEmail());
    }

    public String login(
            String email,
            String password) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid email or password"));
        if (!passwordEncoder.matches(
                password,
                user.getPasswordHash())) {
            throw new IllegalArgumentException(
                    "Invalid email or password");
        }
        return jwtUtil.generateToken(
                String.valueOf(user.getUserId()),
                user.getEmail());
    }

    public String generateResetToken(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String resetToken = UUID.randomUUID().toString();

        user.setResetToken(resetToken);
        user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));

        userRepository.save(user);

        return resetToken;

    }
}

