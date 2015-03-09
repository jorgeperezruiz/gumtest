package com.akudreams.model;

public class ItemOwner {
    private String name;
    private String phoneNumber;
    private String email;
    private String accountCreationDate;

    public ItemOwner(String name, String phoneNumber, String email, String accountCreationDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }
}

