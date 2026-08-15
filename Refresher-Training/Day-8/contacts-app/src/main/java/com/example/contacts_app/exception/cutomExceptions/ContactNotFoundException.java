package com.example.contacts_app.exception.cutomExceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message){
        super(message);
    }
}
