package com.lamzone.mareu.service;


import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public abstract class DummyMeetingGenerator {


    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room(1,"Salle A","https://ibb.co/qRHZN9c"),
            new Room(2,"Salle B","https://ibb.co/qY0FJvX"),
            new Room(3,"Salle C","https://ibb.co/pdNShPs"),
            new Room(4,"Salle D","https://ibb.co/TvN3mzv")
    );

    private static final List<Guest> DUMMY_GUESTS = Arrays.asList(
           new Guest(1,"michel@lamzone.com"),
           new Guest(2,"jeanine@lamzone.com"),
           new Guest(3,"audrey@lamzone.com"),
           new Guest(4,"raphael@lamzone.com"),
           new Guest(5,"julie@lamzone.com")

    );

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(

            new Meeting(1," Appli Entrevoisins",new Date(Long.parseLong("1588579200000")),
                    new Room(1,"Salle A","https://ibb.co/qRHZN9c"),
                    Collections.singletonList(new Guest(1, "michel@lamzone.com"))));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
    static List<Guest> generateGuests(){return  new ArrayList<>(DUMMY_GUESTS);}
    static List<Room> generateRooms(){return  new ArrayList<>(DUMMY_ROOMS);}
}