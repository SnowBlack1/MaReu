package com.lamzone.mareu.DI;

import com.lamzone.mareu.service.DummyMeetingApiService;
import com.lamzone.mareu.service.MeetingApiService;

/**
 * Dependency injector to get instance of services
 */

public class DI {

    private static MeetingApiService service = new DummyMeetingApiService();

    /**
     * Get an instance on @{@link MeetingApiService}
     *
     * @return
     */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetingApiService}.
     *
     * @return
     */
    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}
