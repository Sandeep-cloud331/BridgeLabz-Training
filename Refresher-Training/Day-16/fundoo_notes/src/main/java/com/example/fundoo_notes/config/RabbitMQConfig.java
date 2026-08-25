package com.example.fundoo_notes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME =
            "notes-exchange";
    public static final String REMINDER_QUEUE =
            "reminder-queue";
    public static final String REMINDER_ROUTING_KEY =
            "note.reminder";
    @Bean
    public TopicExchange notesExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
    @Bean
    public Queue reminderQueue() {
        return new Queue(REMINDER_QUEUE);
    }
    @Bean
    public Binding reminderBinding(
            Queue reminderQueue,
            TopicExchange notesExchange) {
        return BindingBuilder
                .bind(reminderQueue)
                .to(notesExchange)
                .with(REMINDER_ROUTING_KEY);
    }
}
