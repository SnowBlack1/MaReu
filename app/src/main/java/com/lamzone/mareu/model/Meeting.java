package com.lamzone.mareu.model;

import android.annotation.SuppressLint;

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
    private Date dayOfMeeting;
    private String subject;
    private List<String> emailList;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Date getDayOfMeeting() {
        return dayOfMeeting;
    }

    public String getRoom() {
        return room;
    }

    private String getSubject() {
        return subject;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public Meeting(int color, String room, Date dayOfMeeting, Date meetingStart, Date meetingEnd, String subject, List<String> emailList) {
        this.color = color;
        this.room = room;
        this.dayOfMeeting = dayOfMeeting;
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

    public String getDay() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        return spf.format(dayOfMeeting);
    }

}
