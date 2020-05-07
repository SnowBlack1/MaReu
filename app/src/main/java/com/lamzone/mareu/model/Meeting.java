package com.lamzone.mareu.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Model object representing a Meeting
 */
public class Meeting implements Serializable {

    private int color;
    private String room;

    public int getColor() {
        return color;
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

    public void setGuestList(List<String> guestList) {
        this.guestList = guestList;
    }

    //private Date startDate;
    //private Date endDate;
    private String subject;
    private List<String> guestList;

    public Meeting(int color,String room,String subject,List<String> guestList){
        this.color = color;
        this.room = room;
        this.subject = subject;
        this.guestList = guestList;
    }

    //public String getInfo() pour date ?



//GETTERS AND SETTERS




    public String getGuestList(){
        StringBuilder guests = new StringBuilder();
        for (String guest :  guestList){
            guests.append(guest).append(" , ");
        }
        return guests.toString();
    }

}
