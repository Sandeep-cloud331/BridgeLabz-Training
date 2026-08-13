package com.example.contacts_app.service;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;
import com.example.contacts_app.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContacsServiceImpl implements ContactsService{

    private  final ContactsRepository contactsRepository;
    public ContacsServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public ResponseDTO saveContacts(RequestDTO requestDTO) {
        Contacts contact = new Contacts();
        contact.setName(requestDTO.getName());
        contact.setEmail(requestDTO.getEmail());
        contact.setPhone(requestDTO.getPhone());
        Contacts contacts =contactsRepository.save(contact);
        ResponseDTO responseDTO = ResponseDTO.builder().name(contacts.getName()).email(contacts.getEmail()).phone(contacts.getPhone()).build();
        return  responseDTO;

    }
}
