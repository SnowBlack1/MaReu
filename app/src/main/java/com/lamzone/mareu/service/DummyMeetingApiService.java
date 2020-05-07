package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;

import java.util.List;

/**Mock for the API*/
public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeeting();


    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public List<Guest> getGuests() {
        return null;
    }

    @Override
    public List<Room> getRooms() {
        return null;
    }

}

