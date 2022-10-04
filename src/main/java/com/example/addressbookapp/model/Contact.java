package com.example.addressbookapp.model;
import com.example.addressbookapp.dto.ContactDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class Contact {
    @Id
    @GeneratedValue
    private Long contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;

    public Contact(ContactDTO contactDTO) {
        this.firstName = contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();
        this.address = contactDTO.getAddress();
        this.state = contactDTO.getState();
        this.city = contactDTO.getCity();
        this.zip = contactDTO.getZip();
        this.phone = contactDTO.getPhone();
    }
}