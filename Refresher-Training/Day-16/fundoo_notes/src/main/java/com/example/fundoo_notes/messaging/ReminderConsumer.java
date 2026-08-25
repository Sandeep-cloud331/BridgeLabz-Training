package com.example.fundoo_notes.messaging;

import com.example.fundoo_notes.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReminderConsumer {

    private final EmailService emailService;

    public ReminderConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    //method: handlePasswordResetRequest
    @JmsListener(
            destination = "password-reset-queue")
    public void handlePasswordResetRequest(
            String messageBody) {
        String[] parts =
                messageBody.split("\\|");
        String email = parts[0];
        String resetToken = parts[1];
        sendActualEmail(
                email,
                resetToken);
    }
    private void sendActualEmail(
            String email,
            String resetToken) {
        try {
            emailService.sendResetPasswordEmail(email,resetToken);
            System.out.println(
                    "Password reset email sent to: "
                            + email);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @JmsListener(destination = "note-reminder-queue")
    public void handleNoteReminder(String msgBody){

        String[] parts = msgBody.split("\\|");

        long noteId = Long.parseLong(parts[0]);
        String reminderTime = parts[1];
        System.out.println("Reminder email sent to: " + reminderTime + " for note: " + noteId);
    }
}
