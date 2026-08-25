package com.example.fundoo_notes.messaging.rabbitMQ;

import com.example.fundoo_notes.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitReminderProducer {
    private final RabbitTemplate rabbitTemplate;

    public RabbitReminderProducer(
            RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReminder(
            String noteTitle,
            int userId) {
        String message =
                noteTitle + "|" + userId;
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.REMINDER_ROUTING_KEY,
                message);
    }
}
