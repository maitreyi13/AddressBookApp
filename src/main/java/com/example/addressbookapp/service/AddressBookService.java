package com.example.addressbookapp.service;
import com.example.addressbookapp.dto.ContactDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    Repo repository;
    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact newContactData = new Contact(contactDTO);
        return repository.save(newContactData);
    }
    @Override
    public Optional<Contact> getContactById(Long contactId) {
        if (repository.findById(contactId).isPresent()) {
            return repository.findById(contactId);
        } else throw new AddressBookException("No contact in database.");
    }
    @Override
    public List<Contact> getContact() {
        if (repository.findAll().isEmpty())
        {
            System.out.println("No data found");
            throw new AddressBookException("No contact in database.");

        } else return repository.findAll();
    }
    @Override
    public Contact updateContact(Long contactId, ContactDTO contactDTO) {
        Contact existingGreet = repository.findById(contactId).orElse(null);
        if (existingGreet != null) {
            existingGreet.setFirstName(contactDTO.getFirstName());
            existingGreet.setLastName(contactDTO.getLastName());
            existingGreet.setAddress(contactDTO.getAddress());
            existingGreet.setState(contactDTO.getState());
            existingGreet.setCity(contactDTO.getCity());
            existingGreet.setZip(contactDTO.getZip());
            existingGreet.setPhone(contactDTO.getPhone());
        }
        assert existingGreet != null;
        return repository.save(existingGreet);
    }

    @Override
    public void deleteContact(Long contactId) {
        repository.deleteById(contactId);
    }
    @Override
    public List<Contact> findByName(String firstName) {
        return (repository.findPersonByName(firstName));
    }
    @Override
    public List<Contact> findByCity(String city) {
        return (repository.findPersonByCity(city));
    }

}