package com.example.contacts_app.dao;

import com.example.contacts_app.entity.Contacts;

import java.util.List;


public interface ContactDAO {
    List<Contacts> getAllContacts();
}
