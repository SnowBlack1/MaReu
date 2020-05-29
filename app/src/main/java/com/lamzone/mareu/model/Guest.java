package com.lamzone.mareu.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Guest implements Serializable {


    private String firstName;
    private String lastName;
    private static String emailAddress = "@lamzone.com";

    private Guest(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        Guest.emailAddress = emailAddress;

    }

    private static final List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest("captain", "america", emailAddress),
            new Guest("fire", "fox", emailAddress),
            new Guest("cat", "woman", emailAddress),
            new Guest("spider", "man", emailAddress),
            new Guest("red", "panda", emailAddress),
            new Guest("lucy", "sakura", emailAddress),
            new Guest("nephenie", "snowblack", emailAddress)
    );

    public static List guestList = addressGenerator();


    private static List addressGenerator() {
        List<String> listEmail = new ArrayList<>();
        for (Guest guest : DUMMY_GUESTS) {
            Collections.shuffle(listEmail); //Get random items from listEmail
            listEmail.add(guest.firstName + "." + guest.lastName + emailAddress);
        }
        return listEmail;
    }

}
