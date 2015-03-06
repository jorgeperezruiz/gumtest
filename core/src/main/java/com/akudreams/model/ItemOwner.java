package com.akudreams.model;

public class ItemOwner {
    private String name;
    private String phoneNumber;
    private String email;
    private String accountCreationDate;
    private String title;

    public ItemOwner(String name, String phoneNumber, String email, String accountCreationDate, String title) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
        this.title = title;
    }

    public String getTitle() {
        return title;
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

