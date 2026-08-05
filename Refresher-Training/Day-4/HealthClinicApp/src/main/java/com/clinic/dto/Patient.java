package com.clinic.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
     String first_name;
     String last_name;
     String date_of_birth;
     String gender;
     String phone_number;
     String email;
     boolean is_active;
     String registered_on;



}
