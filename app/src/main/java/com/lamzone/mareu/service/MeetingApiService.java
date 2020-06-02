package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingApiService {

    /** Get all meetings*/
    List<Meeting> getMeeting();

    /** Delete a meeting*/
    void deleteMeeting(Meeting meeting);

    /**Create a meeting*/
    void createMeeting (Meeting meeting);

    /**Meeting filter by date*/
    List<Meeting> getMeetingByDateFilter(Date date);

    /**Meeting filter by room*/
    List<Meeting> getMeetingByRoomFilter(String room);

    /**Check meeting consistency*/
    //boolean checkingMeeting(Meeting meeting);

}
