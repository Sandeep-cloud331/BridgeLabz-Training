package com.example.contacts_app.service;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;

public interface ContactsService {
    public ResponseDTO saveContacts(RequestDTO requestDTO);
}
