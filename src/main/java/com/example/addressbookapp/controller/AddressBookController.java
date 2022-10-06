package com.example.addressbookapp.controller;
import com.example.addressbookapp.dto.ContactDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Welcome to Address Book Application";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contact;
        contact = iAddressBookService.createContact(contactDTO);
        ResponseDTO response = new ResponseDTO("Contact Created Successfully!", Optional.ofNullable(contact));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/", "/printAll"})
    public ResponseEntity<ResponseDTO> getContactData() {
        List<Contact> contactList = iAddressBookService.getContact();
        System.out.println(contactList.toString());
        ResponseDTO response = new ResponseDTO("Data: ", contactList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/print/{contactId}")
    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") Long contactId) {
        Optional<Contact> contact;
        contact = iAddressBookService.getContactById(contactId);
        ResponseDTO response = new ResponseDTO("Employee details by ID", contact);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") Long contactId,
                                                         @Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = iAddressBookService.updateContact(contactId, contactDTO);
        ResponseDTO response = new ResponseDTO("Contact updated successfully!", "Updated id: \n" + contact);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") Long contactId) {
        iAddressBookService.deleteContact(contactId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + contactId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/contactName/{firstName}")
    public ResponseEntity<ResponseDTO> getPersonByName(@PathVariable String firstName) {
        List<Contact> contactList;
        contactList = iAddressBookService.findByName(firstName);
        ResponseDTO respDTO = new ResponseDTO("Contact details of " + firstName + " :", contactList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/contactCity/{city}")
    public ResponseEntity<ResponseDTO> getPersonByCity(@PathVariable String city) {
        List<Contact> contactList;
        contactList = iAddressBookService.findByCity(city);
        ResponseDTO respDTO = new ResponseDTO("Contact details from " + city + " :", contactList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}