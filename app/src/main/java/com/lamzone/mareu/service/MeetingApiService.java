package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;

import java.util.Date;
import java.util.List;

public interface MeetingApiService {

    /** Get all meetings*/
    List<Meeting> getMeeting();

    /** Delete a meeting*/
    void deleteMeeting(Meeting meeting);

    /**Create a meeting*/
    void createMeeting (Meeting meeting);

    /** Get meeting rooms*/
    List<Room> getRooms();

    /**Meeting filter by date*/
    List<Meeting> getMeetingByDateFilter(Date date);

    /**Meeting filter by room*/
    List<Meeting> getMeetingByRoomFilter(String room);

}
