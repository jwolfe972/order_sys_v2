package com.resturant.orderSystem.services;

import lombok.*;

import java.util.Date;

public class RegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final String pWord;
    private final Date current_date = new Date();


    public RegistrationRequest(String firstName, String lastName, String emailAddress, String phoneNumber, String pWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.pWord = pWord;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getpWord() {
        return pWord;
    }

    public Date getCurrent_date() {
        return current_date;
    }
}
