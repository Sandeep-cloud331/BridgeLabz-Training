package com.example.contacts_app.service;


import com.example.contacts_app.dto.PatchDTO;
import com.example.contacts_app.dto.RequestDTO;
import com.example.contacts_app.dto.ResponseDTO;
import com.example.contacts_app.entity.Contacts;
import com.example.contacts_app.exception.cutomExceptions.ContactNotFoundException;
import com.example.contacts_app.mapper.ContactMapper;
import com.example.contacts_app.repository.ContactsRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContacsServiceImpl implements ContactsService{



    //ContactDAO contactDAO;
    ContactsRepository contactsRepository;
    ContactMapper contactMapper;



    public ContacsServiceImpl(ContactsRepository contactsRepository, ContactMapper contactMapper) {
        this.contactsRepository = contactsRepository;
        this.contactMapper = contactMapper;


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

    @Override
    public Optional<ResponseDTO> getContactByName(String name) {
        Contacts contact = contactsRepository.findByName(name);
        if(contact != null){
            return Optional.of(contactMapper.toDTO(contact));
        }
        return Optional.empty();
    }

    @Override
    public ResponseDTO updateContactPatched(PatchDTO patchDTO, String id) {
        Contacts contact = contactsRepository.findById(Long.parseLong(id)).orElseThrow(()-> new ContactNotFoundException("did not find contact with id "+id));
        System.out.println(patchDTO.getName()+":"+ patchDTO.getEmail());
        if(patchDTO.getName() != null){
            System.out.println("k");
            contact.setName(patchDTO.getName());
        }
        if(patchDTO.getEmail() != null){
            contact.setEmail(patchDTO.getEmail());
        }
        if(patchDTO.getPhone() != null){
            contact.setPhone(patchDTO.getPhone());
        }
        Contacts updatedContact = contactsRepository.save(contact);
        System.out.println(contact.getName());

        return contactMapper.toDTO(updatedContact);

    }
}
