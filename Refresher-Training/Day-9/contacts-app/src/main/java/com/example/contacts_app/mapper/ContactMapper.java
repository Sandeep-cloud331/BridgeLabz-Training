package com.example.contacts_app.mapper;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contacts toEntity(RequestDTO requestDTO ){
        Contacts contacts = new Contacts();
        contacts.setName(requestDTO.getName());
        contacts.setEmail(requestDTO.getEmail());
        contacts.setPhone(requestDTO.getPhone());
        return contacts;
    }

    public ResponseDTO toDTO(Contacts contacts){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(contacts.getId());
        responseDTO.setName(contacts.getName());
        responseDTO.setEmail(contacts.getEmail());
        responseDTO.setPhone(contacts.getPhone());
        return responseDTO;
    }
}
