package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class AddressBookDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Name should start with a capital letter and contain at least 3 characters"
    )
    private String name;

    private String address;
    private String phoneNumber;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}