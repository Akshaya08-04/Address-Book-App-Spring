package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import com.bridgelabz.addressbookapp.util.ResponseDTO;
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
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Call Successful",
                addressBookService.getAddressBookData()
        );
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO(
                "Get Call for ID Successful",
                addressBookService.getAddressBookDataById(id)
        );
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created contact successfully", data);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData data = addressBookService.updateAddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated contact successfully", data);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        addressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted contact successfully", "Deleted id: " + id);
        return ResponseEntity.ok(responseDTO);
    }
}