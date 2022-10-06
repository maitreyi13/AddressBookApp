package com.example.addressbookapp.repo;
import com.example.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository <Contact, Long> {
    @Query(value = "select * from contact where first_name=:firstName",nativeQuery = true)
    List<Contact> findPersonByName(String firstName);
    @Query(value = "select * from contact where city=:city",nativeQuery = true)
    List<Contact> findPersonByCity(String city);
}
