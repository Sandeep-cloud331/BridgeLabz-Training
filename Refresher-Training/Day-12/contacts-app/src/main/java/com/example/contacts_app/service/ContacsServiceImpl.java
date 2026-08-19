package com.example.contacts_app.service;


import com.example.contacts_app.dto.PatchDTO;
import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;
import com.example.contacts_app.exception.cutomExceptions.ContactNotFoundException;
import com.example.contacts_app.mapper.ContactMapper;
import com.example.contacts_app.repository.ContactsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContacsServiceImpl implements ContactsService{

    private static final Logger log = LoggerFactory.getLogger(ContacsServiceImpl.class);

    //ContactDAO contactDAO;
    ContactsRepository contactsRepository;
    ContactMapper contactMapper;



    public ContacsServiceImpl(ContactsRepository contactsRepository, ContactMapper contactMapper) {
        this.contactsRepository = contactsRepository;
        this.contactMapper = contactMapper;


    }


    @Override
    public ResponseDTO saveContacts(RequestDTO requestDTO) {
        log.info("Saving new contact with name: {}", requestDTO.getName());
        Contacts contacts = contactMapper.toEntity(requestDTO);
        Contacts savedContact = contactsRepository.save(contacts);
        log.info("Contact saved with id: {}", savedContact.getId());
        return contactMapper.toDTO(savedContact);
    }

    @Override
    public ResponseDTO updateContacts(RequestDTO requestDTO, String id) {
        log.info("Updating contact with id: {}", id);
        Contacts contacts = contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new RuntimeException("Contact not found"));

        contacts.setName(requestDTO.getName());
        contacts.setEmail(requestDTO.getEmail());
        contacts.setPhone(requestDTO.getPhone());
        contactsRepository.save(contacts);
        log.info("Contact with id: {} updated successfully", id);
        return contactMapper.toDTO(contacts);
    }

    @Override
    public ResponseDTO getContactsById(String id) {
        log.info("Fetching contact with id: {}", id);
        Contacts contact = contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ContactNotFoundException(id));
        return contactMapper.toDTO(contact);
    }

    @Override
    public List<ResponseDTO> getAllContacts() {
        log.info("Fetching all contacts");
        List<Contacts> contacts = contactsRepository.findAll();
        List<ResponseDTO> responseDTOS = new ArrayList<>();
        for (Contacts contact : contacts) {
            responseDTOS.add(contactMapper.toDTO(contact));
        }
        log.info("Returning {} contacts", responseDTOS.size());
        return responseDTOS;
    }

    @Override
    public String deleteContacts(String id) {
        log.info("Deleting contact with id: {}", id);
        contactsRepository.deleteById(Long.parseLong(id));
        log.info("Contact with id: {} deleted successfully", id);
        return "Contact deleted successfully";
    }

    @Override
    public Optional<ResponseDTO> getContactByName(String name) {
        log.info("Fetching contact by name: {}", name);
        Contacts contact = contactsRepository.findByName(name);
        if (contact != null) {
            return Optional.of(contactMapper.toDTO(contact));
        }
        log.warn("No contact found with name: {}", name);
        return Optional.empty();
    }

    @Override
    public ResponseDTO updateContactPatched(PatchDTO patchDTO, String id) {
        log.info("Patching contact with id: {}", id);
        Contacts contact = contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ContactNotFoundException("did not find contact with id "+id));
        log.debug("Patch data - name: {}, email: {}", patchDTO.getName(), patchDTO.getEmail());
        if (patchDTO.getName() != null) {
            contact.setName(patchDTO.getName());
        }
        if (patchDTO.getEmail() != null) {
            contact.setEmail(patchDTO.getEmail());
        }
        if (patchDTO.getPhone() != null) {
            contact.setPhone(patchDTO.getPhone());
        }
        Contacts updatedContact = contactsRepository.save(contact);
        log.info("Contact with id: {} patched successfully, new name: {}", id, updatedContact.getName());
        return contactMapper.toDTO(updatedContact);
    }
}
