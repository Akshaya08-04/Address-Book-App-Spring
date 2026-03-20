package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Get all address book contacts");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Get address book contact by id: " + id);
    }

    @PostMapping
    public ResponseEntity<String> createContact() {
        return ResponseEntity.ok("Create new address book contact");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id) {
        return ResponseEntity.ok("Update address book contact by id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Delete address book contact by id: " + id);
    }
}