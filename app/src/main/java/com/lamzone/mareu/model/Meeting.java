package com.lamzone.mareu.model;

import java.io.Serializable;

/**
 * Model object representing a Meeting
 */
public class Meeting implements Serializable {
    //Identifier
    private int id;

    //Room name
    private String roomName;

    //Room image
    private String roomImgUrl;

    //Meeting hour
    private int hour;

    //Meeting Subject
    private String meetingSubject;

    //Meeting participant
    private String participant;

    /**
     * Constructor
     */
    public Meeting(int id, String roomName, String roomImgUrl, int hour, String meetingSubject, String participant) {
        this.id = id;
        this.roomName = roomName;
        this.roomImgUrl = roomImgUrl;
        this.hour = hour;
        this.meetingSubject = meetingSubject;
        this.participant = participant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomImgUrl() {
        return roomImgUrl;
    }

    public void setRoomImgUrl(String roomImgUrl) {
        this.roomImgUrl = roomImgUrl;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    //generate equals & hashCode ?
}
