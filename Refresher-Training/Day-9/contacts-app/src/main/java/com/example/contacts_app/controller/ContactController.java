package com.example.contacts_app.controller;

import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.service.ContactsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    ContactsService contactsService;
    public ContactController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveContact(@Valid @RequestBody RequestDTO requestDTO){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactsService.saveContacts(requestDTO));

    }
    @PutMapping("/{id}")
    public ResponseDTO updateContact(@Valid @RequestBody RequestDTO requestDTO, @PathVariable String id ){
        return contactsService.updateContacts(requestDTO,id);

    }
    @GetMapping("/{id}")
    public ResponseDTO getContactsById(@PathVariable String id){
        return contactsService.getContactsById(id);
    }


    @GetMapping
    public List<ResponseDTO> getAllContacts(){
        return contactsService.getAllContacts();
    }


    @DeleteMapping("/{id}")
    public String deleteContacts(@PathVariable String id){
        return contactsService.deleteContacts(id);
    }
}
