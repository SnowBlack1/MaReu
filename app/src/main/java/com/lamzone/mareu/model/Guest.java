package com.lamzone.mareu.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private static String emailAddress = "@lamzone.com";

    public Guest(int id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Guest.emailAddress = emailAddress;

    }

    private static final List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest(1, "captain", "america", emailAddress),
            new Guest(2, "fire", "fox", emailAddress),
            new Guest(3, "cat", "woman", emailAddress),
            new Guest(4, "spider", "man", emailAddress)


    );

    public static List guestList = addressGenerator();


    private static List addressGenerator() {
        List<String> listEmail = new ArrayList<>();
        for (Guest guest : DUMMY_GUESTS) {
            listEmail.add(guest.firstName+ "." + guest.lastName + emailAddress);
        }
        return listEmail;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static void setEmailAddress(String emailAddress) {
        Guest.emailAddress = emailAddress;
    }
}
