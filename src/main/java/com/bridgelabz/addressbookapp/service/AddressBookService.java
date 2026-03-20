package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> list = new ArrayList<>();
        list.add(new AddressBookData(1, new AddressBookDTO("Akshaya", "Chennai", "9876543210")));
        return list;
    }

    @Override
    public AddressBookData getAddressBookDataById(int id) {
        return new AddressBookData(id, new AddressBookDTO("Akshaya", "Chennai", "9876543210"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        return new AddressBookData(1, addressBookDTO);
    }

    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        return new AddressBookData(id, addressBookDTO);
    }

    @Override
    public void deleteAddressBookData(int id) {
        System.out.println("Deleted contact with id: " + id);
    }
}