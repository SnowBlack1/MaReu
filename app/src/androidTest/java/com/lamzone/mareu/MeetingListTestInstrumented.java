package com.lamzone.mareu;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.UI.MeetingListActivity;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.MeetingApiService;
import com.lamzone.mareu.utils.DeleteViewAction;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lamzone.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingListTestInstrumented {

    private static final MeetingApiService apiService = DI.getNewInstanceApiService();
    private static final int MEETING_LIST_SIZE = apiService.getMeeting().size();

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule =
            new ActivityTestRule(MeetingListActivity.class);

    @Before
    public void setUp() {
        MeetingListActivity activity = mActivityTestRule.getActivity();
        assertThat(activity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void meetingList_shouldNotBeEmpty() {
        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void deleteAction_shouldRemoveItem() {
        int ITEMS_COUNT = 5;
        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasChildCount(ITEMS_COUNT)));

        onView(withId(R.id.recycler_view_meeting_list))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));

        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasChildCount(ITEMS_COUNT - 1)));
    }

    @Test
    public void addMeetingWithSuccess(){
        //Checking that items count is equal to MEETING_LIST_SIZE
        onView(withId(R.id.main_layout_meeting_list)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE));

        // Click on the creation button for a new meeting
        onView(withId(R.id.add_meeting))
                .perform(click());
        //Click on imageView to change color
        onView(withId(R.id.color_meeting)).perform(click());

        // Subject
        onView(withId(R.id.meeting_subject_txt))
                .perform(click());
        onView(withId(R.id.meeting_subject_txt))
                .perform(typeText("test"));

        // Date choice
        onView(withId(R.id.date_picker_txt))
                .perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 6, 6));
        onView(withText("OK")).perform(click());

        //Meeting start time choice
        onView(withId(R.id.start_time_picker_txt)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(15, 0));
        onView(withText("OK")).perform(click());

        //Meeting end time choice
        onView(withId(R.id.end_time_picker_txt)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(16,0));
        onView(withText("OK")).perform(click());

        // Room choice
        onView(withId(R.id.meeting_room_spinner))
                .perform(click());
        onData(anything()).atPosition(3).perform(click());

        // Enter of meeting guest email
        onView(withId(R.id.guest_email))
                .perform(click())
                .perform(typeText("fire"));
        //onData(anything()).atPosition(1).perform(click());

        // Click on the creation button for a new meeting
        onView(withId(R.id.meeting_save)).perform(scrollTo(),click());

        //onView(withId(R.id.recycler_view_meeting_list)).check(matches(isDisplayed()));
        //onView(withId(R.id.main_layout_meeting_list)).check(matches(isDisplayed()));

        // Checking that count of items is equal to MEETING_LIST_SIZE +1
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE + 1));


        //onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE +1));
    }
        //onView(withId(R.id.recycler_view_meeting_list)).check(matches(isDisplayed()));
        //onView(withClassName(Matchers.equalTo(RecyclerView.class.getName()))).check(withItemCount(MEETING_LIST_SIZE + 1));


    @Test
    public void filterMeetingByDate() {
        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_filter))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText("Filtrer par date"))
                .perform(click());
        // Pick a date, example 14th july 2020 ( 1 meetings hardcoded in DummyMeetingGenerator for this date )
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 7, 14));
        onView(withText("OK")).perform(click());

        // We check that the count of item is 1 ->Because 1 meeting hardcoded in DUMMY_MEETING generator
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(1));

        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_filter))
                .perform(click());

        // Click on the item menu filter by date
        onView(withText("Filtrer par date"))
                .perform(click());

        onView(withText("Reset")).perform(click());

        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_filter))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText("Filtrer par date"))
                .perform(click());

        // Pick another date, example 15th august 2020 ( 0 meetings)
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 8, 15));
        onView(withText("OK")).perform(click());

        // We check that the count of items is 0
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(0));
    }

    @Test
    public void filterMeetingByRoom() {
        // Before setting the filter => MEETING_LIST_SIZE
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE));
        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_filter))
                .perform(click());
        // Click on the item menu filter by date
        onView(withText("Filtrer par salle"))
                .perform(click());

        // Pick a room ("Salle A" = 1 meetings hardcoded)
        String room = "Salle A";
        onView(withText(room)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(getNumberMeetingsWithRoomText(room)));

        // Open the overflow menu
        onView(withId(R.id.menu_overflow_button_filter))
                .perform(click());

        // Click on the item menu filter by date
        onView(withText("Filtrer par salle"))
                .perform(click());

        // Reset the filter => MEETING_LIST_SIZE
        onView(withText("Reset")).perform(click());
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE));
    }

    private int getNumberMeetingsWithRoomText(String room) {
        int numberMeetingsWithRoomText = 0;
        for (Meeting mRoom : apiService.getMeeting()) {
            if (mRoom.getRoom().equals(room)) numberMeetingsWithRoomText += 1;
        }
        return numberMeetingsWithRoomText;


    }
}
