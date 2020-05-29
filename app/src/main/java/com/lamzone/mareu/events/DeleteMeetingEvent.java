package com.lamzone.mareu.events;

import com.lamzone.mareu.model.Meeting;

public class DeleteMeetingEvent {

    /**
     * Meeting to delete
     **/

    public Meeting meeting;


    /**
     * Constructor
     *
     * @param meeting
     */
    public DeleteMeetingEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}
