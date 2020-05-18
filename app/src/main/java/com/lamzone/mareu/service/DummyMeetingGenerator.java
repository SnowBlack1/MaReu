package com.lamzone.mareu.service;


import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.rgb;

public abstract class DummyMeetingGenerator {
    //1 day = 86400000 millis 1h = 360000 millis
    //30min = 1800000

    private static int meetingColor;

    public static int getActualColor() {
        return meetingColor;
    }


    public static List<Meeting> DUMMY_MEETING = Arrays.asList(
            new Meeting(generateColor(), "Salle A",new Date(Long.parseLong("1589666400000")),new Date(Long.parseLong("1589666400000") + 54000000),
                    new Date(Long.parseLong("1589666400000") + 61200000), "Brainstorming",Guest.guestList),
            new Meeting(generateColor(), "Salle B",new Date(Long.parseLong("1663020000000")),new Date(Long.parseLong("1663020000000") + 36000000),
                    new Date(Long.parseLong("1663020000000") +50400000 ), "Grands Comptes", Guest.guestList),
            new Meeting(generateColor(), "Salle C",new Date(Long.parseLong("1686866400000")),new Date(Long.parseLong("1686866400000") +  48600000),
                    new Date(Long.parseLong("1686866400000") +  66600000), "Télétravail", Guest.guestList),
            new Meeting(generateColor(), "Salle D",new Date(Long.parseLong("1594677600000")),new Date(Long.parseLong("1594677600000") +  28800000),
                    new Date(Long.parseLong("1594677600000") + 32400000), "Evaluation annuelle",Guest.guestList),
            new Meeting(generateColor(),"Salle E",new Date(Long.parseLong("1605135600000")),new Date(Long.parseLong("1605135600000") + 75600000),
                    new Date(Long.parseLong("1605135600000") +79200000),"Tickets restaurant",Guest.guestList)
    );

    static List<Meeting> generateMeeting() {
        return new ArrayList<>(DUMMY_MEETING);
    }

    public static int generateColor() {
        meetingColor = rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
        return meetingColor;
    }




}