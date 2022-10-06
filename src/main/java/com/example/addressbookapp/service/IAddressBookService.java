package com.example.addressbookapp.service;
import com.example.addressbookapp.dto.ContactDTO;
import com.example.addressbookapp.model.Contact;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    List<Contact> getContact();

    Contact updateContact(Long contactId, ContactDTO contactDTO);

    Contact createContact(ContactDTO contactDTO);

    Optional<Contact> getContactById(Long contactId);
    void deleteContact(Long contactId);

    List<Contact> findByName(String firstName);

    List<Contact> findByCity(String city);
}