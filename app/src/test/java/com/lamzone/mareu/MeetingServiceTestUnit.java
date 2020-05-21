package com.lamzone.mareu;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.graphics.Color.rgb;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MeetingServiceTestUnit {

    private static MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetingWithSuccess() {
        List<Meeting> meeting = service.getMeeting();
        List<Meeting> expectedMeeting = DummyMeetingGenerator.DUMMY_MEETING;
        assertThat(meeting, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeeting.toArray()));
    }

    @Test
    public void addMeetingWithSuccess(){
        Date startMeeting = new Date();
        Date endMeeting = new Date();
        Date dayOfMeeting = new Date();

        List<String> list = new ArrayList<>(Arrays.asList("test@test.com","test2@test.com"));
        Meeting test = new Meeting(rgb(100,150,200),"Salle A",dayOfMeeting,startMeeting,endMeeting,"test",list);
        service.createMeeting(test);
        assertTrue(service.getMeeting().contains(test));
    }

    @Test
    public void deleteMeetingWithSuccess(){
        Meeting meetingToDelete = service.getMeeting().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));

    }

    @Test
    public void filterByDateWithSuccess() {
        List<String> list = new ArrayList<>(Arrays.asList("1@1.1", "2@2.2"));
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(Calendar.DAY_OF_MONTH, calendarDate.get(Calendar.DAY_OF_MONTH) + 1);
        Meeting test = new Meeting(rgb(100, 150, 200), "Salle A",calendarDate.getTime(), calendarDate.getTime(), calendarDate.getTime(), "test", list);
        service.createMeeting(test);

        assertTrue(service.getMeetingByDateFilter(calendarDate.getTime()).contains(test));

    }

    @Test
    public void filterByRoomWithSuccess() {
        List<String> list = new ArrayList<>(Arrays.asList("1@1.1", "2@2.2"));
        Calendar cal = Calendar.getInstance();
        Meeting test = new Meeting(rgb(100, 150, 200), "Salle A", cal.getTime(), cal.getTime(), cal.getTime(), "test", list);
        service.createMeeting(test);

        assertEquals(2, service.getMeetingByRoomFilter("Salle A").size());

    }


}