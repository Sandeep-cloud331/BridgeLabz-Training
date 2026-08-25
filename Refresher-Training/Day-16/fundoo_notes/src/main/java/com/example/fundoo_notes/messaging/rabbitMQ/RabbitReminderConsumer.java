package com.example.fundoo_notes.messaging.rabbitMQ;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReminderConsumer {
    private static final Logger logger =
            LoggerFactory.getLogger(
                    RabbitReminderConsumer.class);
    @RabbitListener(queues = "reminder-queue")
    public void handleReminder(String message) {
        String[] parts =
                message.split("\\|");
        logger.info(
                "REMINDER (via RabbitMQ): " +
                        "note='{}' for userId={}",
                parts[0], parts[1]);
    }
}
