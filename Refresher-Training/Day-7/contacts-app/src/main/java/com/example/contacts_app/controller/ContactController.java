package com.example.contacts_app.controller;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.service.ContactsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactsService contactsService;
    public ContactController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping("/save")
    public RequestDTO saveContacts(@RequestBody RequestDTO requestDTO ){
        return contactsService.saveContacts(requestDTO);
    }
}
