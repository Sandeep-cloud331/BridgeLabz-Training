package com.example.contacts_app.service;

import com.example.contacts_app.annotation.LogExecution;
import com.example.contacts_app.controller.ContactController;
import com.example.contacts_app.dao.ContactDAO;
import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;
import com.example.contacts_app.exception.cutomExceptions.ContactNotFoundException;
import com.example.contacts_app.mapper.ContactMapper;
import com.example.contacts_app.repository.ContactsRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContacsServiceImpl implements ContactsService{



    //ContactDAO contactDAO;
    ContactsRepository contactsRepository;
    ContactMapper contactMapper;



    public ContacsServiceImpl(ContactsRepository contactsRepository, ContactMapper contactMapper, ContactDAO contactDAO) {
        this.contactsRepository = contactsRepository;
        this.contactMapper = contactMapper;
        //this.contactDAO = contactDAO;

    }


    @Override
    public ResponseDTO saveContacts(RequestDTO requestDTO) {
        Contacts contacts =contactMapper.toEntity(requestDTO);
        Contacts savedContact =contactsRepository.save(contacts);
        return contactMapper.toDTO(savedContact);


    }
    @Override
    public ResponseDTO updateContacts(RequestDTO requestDTO,String id) {
        Contacts contacts = contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new RuntimeException("Contact not found"));

        contacts.setName(requestDTO.getName());
        contacts.setEmail(requestDTO.getEmail());
        contacts.setPhone(requestDTO.getPhone());
        contactsRepository.save(contacts);
        return contactMapper.toDTO(contacts);
    }


    @Override
    public ResponseDTO getContactsById(String id) {
        Contacts contact =contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ContactNotFoundException(id));
        return contactMapper.toDTO(contact);

    }

    @Override
    public List<ResponseDTO> getAllContacts() {
        List<Contacts> contacts = contactsRepository.findAll();
        List<ResponseDTO> responseDTOS = new ArrayList<>();
        for (Contacts contact : contacts) {
            responseDTOS.add(contactMapper.toDTO(contact));

        }
        return responseDTOS;
    }

    @Override
    public String deleteContacts(String id) {
       contactsRepository.deleteById(Long.parseLong(id));
        return "Contact deleted successfully";
    }
}
