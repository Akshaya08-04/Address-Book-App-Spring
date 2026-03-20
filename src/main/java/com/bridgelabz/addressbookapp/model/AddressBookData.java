package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

public class AddressBookData {
    private int id;
    private String name;
    private String city;
    private String phoneNumber;

    public AddressBookData() {
    }

    public AddressBookData(int id, AddressBookDTO dto) {
        this.id = id;
        this.name = dto.getName();
        this.city = dto.getCity();
        this.phoneNumber = dto.getPhoneNumber();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}