package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import com.bridgelabz.addressbookapp.util.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllContacts() {
        ResponseDTO responseDTO = new ResponseDTO("Retrieved all contacts successfully",
                addressBookService.getAddressBookData());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Retrieved contact successfully",
                addressBookService.getAddressBookDataById(id));
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Created contact successfully",
                addressBookService.createAddressBookData(addressBookDTO));
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Updated contact successfully",
                addressBookService.updateAddressBookData(id, addressBookDTO));
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        addressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted contact successfully", "Deleted id: " + id);
        return ResponseEntity.ok(responseDTO);
    }
}