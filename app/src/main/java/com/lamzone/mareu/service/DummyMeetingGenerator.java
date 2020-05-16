package com.lamzone.mareu.service;


import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.rgb;

public abstract class DummyMeetingGenerator {

    private static int meetingColor;

    public static int getActualColor() {
        return meetingColor;
    }


    public static List<Meeting> DUMMY_MEETING = Arrays.asList(
            new Meeting(generateColor(), "Salle A",generateStartMeeting(),generateEndMeeting(), "Brainstorming",Guest.guestList),
            new Meeting(generateColor(), "Salle B",generateStartMeeting(),generateEndMeeting(), "Grands Comptes", Guest.guestList),
            new Meeting(generateColor(), "Salle C",generateStartMeeting(),generateEndMeeting(), "Télétravail", Guest.guestList),
            new Meeting(generateColor(), "Salle D",generateStartMeeting(),generateEndMeeting(), "Evaluation annuelle", Guest.guestList)
    );

    static List<Meeting> generateMeeting() {
        return new ArrayList<>(DUMMY_MEETING);
    }

    public static int generateColor() {
        meetingColor = rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
        return meetingColor;
    }

    private static Date generateStartMeeting() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    private static Date generateEndMeeting() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 9);
       cal.set(Calendar.MINUTE, 0);
        return cal.getTime();
    }

}