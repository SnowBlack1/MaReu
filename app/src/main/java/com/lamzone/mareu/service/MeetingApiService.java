package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;

import java.util.List;

public interface MeetingApiService {

    /** Get all meetings*/
    List<Meeting> getMeetings();

    /** Delete a meeting*/
    void deleteMeeting(Meeting meeting);

    /**Create a meeting*/
    void createMeeting (Meeting meeting);

    List<Room> getRooms();

    //boolean checkingMeeting ?

    //List<Meeting> getMeetingByDateFilter
    //List<Meeting> getMeetingByRoomFilter
}
