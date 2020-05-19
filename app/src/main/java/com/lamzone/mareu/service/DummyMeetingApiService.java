package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Mock for the API
 */
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
    public List<Room> getRooms() {
        return null;
    }

    @Override
    public List<Meeting> getMeetingByDateFilter(Date date) {
        List<Meeting> mMeetingFilteredDate = new ArrayList<>();

        Calendar calSelected = Calendar.getInstance();
        calSelected.setTime(date);

        for (Meeting meeting : meetings) {
            Calendar meetingCal = Calendar.getInstance();
            meetingCal.setTime(meeting.getDayOfMeeting());

            if (meetingCal.get(Calendar.DAY_OF_MONTH) == calSelected.get(Calendar.DAY_OF_MONTH)
                    && meetingCal.get(Calendar.MONTH)
                    == calSelected.get(Calendar.MONTH) && meetingCal.get(Calendar.YEAR)
                    == calSelected.get(Calendar.YEAR))
                mMeetingFilteredDate.add(meeting);
        }
        return mMeetingFilteredDate;
    }

    @Override
    public List<Meeting> getMeetingByRoomFilter(String room) {
        List<Meeting> mMeetingFilteredRoom = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getRoom().equals(room))
                mMeetingFilteredRoom.add(meeting);
        }
        return mMeetingFilteredRoom;
    }


    //checkingMeeting?


}
