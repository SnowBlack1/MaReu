package com.lamzone.mareu.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Model object representing a Meeting
 */
public class Meeting implements Serializable {
    //Identifier
    private int id;

    //Room
    private Room room;

    //Meeting date
    private Date mMeetingDate;

    //Meeting Subject
    private String meetingSubject;

    //Meeting guests
    private List<Guest> mGuests;


    /**
     * Constructor
     */
    public Meeting(int id, String meetingSubject, Date date, Room room, List<Guest> guests) {
        this.id = id;
        this.room = room;
        this.mMeetingDate = date;
        this.meetingSubject = meetingSubject;
        this.mGuests = guests;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public Date getMeetingDate() {
        return mMeetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        mMeetingDate = meetingDate;
    }

    public List<Guest> getGuests() {
        return mGuests;
    }

    public void setGuests(List<Guest> guests) {
        mGuests = guests;
    }


}
