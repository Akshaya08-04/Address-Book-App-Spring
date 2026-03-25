package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> addressBookList = new ArrayList<>();
    private int count = 1;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int id) {
        return addressBookList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address Book contact not found for id: " + id));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData newContact = new AddressBookData(count++, addressBookDTO.getName(),
                addressBookDTO.getAddress(), addressBookDTO.getPhoneNumber());
        addressBookList.add(newContact);
        return newContact;
    }

    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData contact = this.getAddressBookDataById(id);
        contact.setName(addressBookDTO.getName());
        contact.setAddress(addressBookDTO.getAddress());
        contact.setPhoneNumber(addressBookDTO.getPhoneNumber());
        return contact;
    }

    @Override
    public void deleteAddressBookData(int id) {
        AddressBookData contact = this.getAddressBookDataById(id);
        addressBookList.remove(contact);
    }
}