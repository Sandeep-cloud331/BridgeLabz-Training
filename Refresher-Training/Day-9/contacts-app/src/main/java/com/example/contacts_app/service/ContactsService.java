package com.example.contacts_app.service;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ContactsService {
    public ResponseDTO saveContacts(RequestDTO requestDTO);
    public ResponseDTO updateContacts(RequestDTO requestDTO,String id);
    public ResponseDTO getContactsById(String id);
    public List<ResponseDTO> getAllContacts();
    public String deleteContacts(String id);
}
