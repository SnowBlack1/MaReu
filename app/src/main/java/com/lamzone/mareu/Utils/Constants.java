package com.lamzone.mareu.Utils;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.service.MeetingApiService;

public class Constants {

    //public static final String MEETING_KEY = "meeting";
    private static final MeetingApiService apiService = DI.getNewInstanceApiService();
    public static final int MEETING_LIST_SIZE = apiService.getMeeting().size();
}
