package com.example.addressbookapp.repo;
import com.example.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository <Contact, Long> {
}
