package com.example.contacts_app.controller;

import com.example.contacts_app.dto.PatchDTO;
import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.service.ContactsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @GetMapping("/name")
    public ResponseEntity<ResponseDTO> getContactByName(@RequestParam String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( contactsService.getContactByName(name).get());

    }

    @GetMapping
    public List<ResponseDTO> getAllContacts(){
        return contactsService.getAllContacts();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO> UpdateContactPatched(@Valid @RequestBody PatchDTO patchDTO, @PathVariable String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactsService.updateContactPatched(patchDTO,id));
    }
    @PatchMapping
    public ResponseEntity<ResponseDTO> UpdateContactPatchedByName(@RequestParam String name, @RequestParam String email, @RequestParam String phone){
        RequestDTO dto = new RequestDTO();
        dto.setName(String.valueOf(name));
        dto.setEmail(String.valueOf(email));
        dto.setPhone(String.valueOf(phone));
        log.info("{}here it is", dto.toString());
        return ResponseEntity.ok(contactsService.saveContacts(dto));

    }


    @DeleteMapping("/{id}")
    public String deleteContacts(@PathVariable String id){
        return contactsService.deleteContacts(id);
    }
}
