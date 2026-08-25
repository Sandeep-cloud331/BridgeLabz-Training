package com.example.fundoo_notes.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReminderProducer {

    //JmsTemplate
    private final JmsTemplate jmsTemplate;

    //Constructor Injection
    public ReminderProducer(
            JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    //method: sendPasswordResetRequest
    public void sendPasswordResetRequest(
            String email,
            String resetToken) {
        String messageBody =
                email + "|" + resetToken;
        jmsTemplate.convertAndSend(
                "password-reset-queue",
                messageBody);
        System.out.println("Link sent to:"+ email);
    }

    public void sendReminderRequest(int noteId, LocalDateTime reminderAt){
        String messageBody = noteId + "|" + reminderAt;
        jmsTemplate.convertAndSend("reminder-queue", messageBody);

    }
}
