package com.example.contacts_app.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponse{
    private HttpStatus status;
    private String error;
    private String message;
}
