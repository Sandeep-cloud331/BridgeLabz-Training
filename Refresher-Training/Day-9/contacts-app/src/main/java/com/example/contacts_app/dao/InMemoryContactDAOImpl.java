package com.example.contacts_app.dao;

import com.example.contacts_app.entity.Contacts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryContactDAOImpl implements ContactDAO{
    @Override
    public List<Contacts> getAllContacts() {
        return List.of();
    }
}
