package com.example.addressbookapp.dto;
import com.example.addressbookapp.model.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDTO {
    String message;
    Object response;

    public ResponseDTO(String message, String response) {
        this.message = message;
        this.response = response;
    }

    public ResponseDTO(String message, Optional<Contact> response) {
        this.message = message;
        this.response = response;
    }

    public ResponseDTO(String message, List<Contact> response) {
        this.message = message;
        this.response = response;
    }
}