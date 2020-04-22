package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;

import java.util.List;

public interface MeetingApiService {

    /** Get all meetings*/
    List<Meeting> getMeetings();

    /** Delete a meeting*/
    void deleteMeeting(Meeting meeting);

    /**Create a meeting*/
    void createMeeting (Meeting meeting);

}
