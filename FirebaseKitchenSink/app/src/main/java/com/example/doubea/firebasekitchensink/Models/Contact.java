package com.example.doubea.firebasekitchensink.Models;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Contact {

    public String contactID;
    public String name;
    public String phoneNumber;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Contact( String name, String phoneNumber, String contactId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.contactID = contactId;
    }

}