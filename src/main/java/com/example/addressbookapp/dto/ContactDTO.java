package com.example.addressbookapp.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public @ToString class ContactDTO {
    @Id
    @GeneratedValue
    long contactId;
    @NotEmpty (message = "First name can not be empty")
    @Pattern(regexp="^[A-Z][a-zA-Z\\s]{2,}$", message="Invalid Name(Should have one upper case and min three Characters.)")
    public String firstName;
    @NotEmpty (message = "Last name can not be empty")
    @Pattern(regexp="^[A-Z][a-zA-Z\\s]{2,}$", message="Invalid Name(Should have one upper case and min three Characters.)")
    public String lastName;
    @NotEmpty(message = "Address Cannot be Empty")
    public String address;
    @NotBlank(message = "State Cannot be Empty")
    public String state;
    public String city;
    @Pattern(regexp = "^[1-9][0-9]{5}$", message="Invalid Zip Code(First digit is non-zero, Should be 6 digit), example: 234098")
    public String zip;
    @Pattern(regexp = "^[1-9]{2}[0-9]{10}$", message="Invalid Contact Number(Should have Country Code and must be 10 digit number) example: 919234567890")
    public String phone;
}