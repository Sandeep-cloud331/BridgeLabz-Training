package com.example.contacts_app.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;



@Data
public class PatchDTO {
    private String name;
    private String phone;
    @Email
    private  String email;
}
