package com.example.contacts_app.dao;

import com.example.contacts_app.entity.Contacts;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class ContactDAOImpl implements ContactDAO {

    @Override
    public List<Contacts> getAllContacts() {
        return List.of();
    }
}
