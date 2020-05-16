package com.lamzone.mareu.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Model object representing a Meeting
 */
public class Meeting implements Serializable {

    private int color;
    private String room;
    private Date meetingStart;
    private Date meetingEnd;
    private Date dayMeeting;
    private String subject;
    private List<String> emailList;
    private List<String> meetings;

    public Date getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(Date meetingStart) {
        this.meetingStart = meetingStart;
    }

    public Date getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(Date meetingEnd) {
        this.meetingEnd = meetingEnd;
    }


    public int getColor() {
        return color;
    }


    public List<String> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<String> meetings) {
        this.meetings = meetings;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public Meeting(int color, String room, Date meetingStart, Date meetingEnd, String subject, List<String> emailList) {
        this.color = color;
        this.room = room;
        this.meetingStart = meetingStart;
        this.meetingEnd = meetingEnd;
        this.subject = subject;
        this.emailList = emailList;
    }

    public String getInfo() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.FRANCE);
        return this.getRoom() + " - " + dateFormat.format(meetingStart).replace(":",
                "h") + " / " + dateFormat.format(meetingEnd).replace(":", "h")
                + " - " + this.getSubject();
    }

    //public String getDay(){
        //SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        //return this + format.format(dayMeeting);
    //}


}
