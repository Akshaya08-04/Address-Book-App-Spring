package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> addressBookList = new ArrayList<>();
    private int contactIdCounter = 1;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int id) {
        return addressBookList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData newContact = new AddressBookData(contactIdCounter++, addressBookDTO);
        addressBookList.add(newContact);
        return newContact;
    }

    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData existingContact = getAddressBookDataById(id);
        if (existingContact != null) {
            existingContact.setName(addressBookDTO.getName());
            existingContact.setCity(addressBookDTO.getCity());
            existingContact.setPhoneNumber(addressBookDTO.getPhoneNumber());
        }
        return existingContact;
    }

    @Override
    public void deleteAddressBookData(int id) {
        addressBookList.removeIf(contact -> contact.getId() == id);
    }
}