package com.example.fundoo_notes.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendResetPasswordEmail(String to, String token) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("yourgmail@gmail.com");
        message.setTo(to);
        message.setSubject("Reset your password");
        message.setText(
                "Reset link: http://localhost:8080/reset-password?token=" + token
        );

        javaMailSender.send(message);

        System.out.println("Reset email sent to: " + to);
    }
}
