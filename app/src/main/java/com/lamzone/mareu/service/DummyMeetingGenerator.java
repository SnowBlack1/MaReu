package com.lamzone.mareu.service;


import com.lamzone.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(

            new Meeting(1, "Salle A", "https://ibb.co/qRHZN9c", "14h00",
                    "Réunion A", "michel@lamzone.com" + "jeanine@lamzone.com"),
            new Meeting(2, "Salle B", "https://ibb.co/qY0FJvX", "9h30",
                    "Réunion B,", "audrey@lamzone.com"),
            new Meeting(3,"Salle C","https://ibb.co/pdNShPs","10h00",
                    "Réunion C","julie@lamzone.com"),
            new Meeting(4,"Salle D","https://ibb.co/TvN3mzv","15h15",
                    "Réunion D","raphael@lamzone.com"));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}