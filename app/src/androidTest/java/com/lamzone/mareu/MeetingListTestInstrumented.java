package com.lamzone.mareu;

import android.widget.DatePicker;

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
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lamzone.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MeetingListTestInstrumented {

    private static final MeetingApiService apiService = DI.getNewInstanceApiService();
    private static final int MEETING_LIST_SIZE = apiService.getMeeting().size();

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule =
            new ActivityTestRule<>(MeetingListActivity.class);

    @Before
    public void setUp() {
        MeetingListActivity activity = mActivityTestRule.getActivity();
        assertThat(activity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void a_meetingList_shouldNotBeEmpty() {
        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void d_deleteAction_shouldRemoveItem() {
        //int ITEMS_COUNT = 5;
        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasChildCount(MEETING_LIST_SIZE)));

        onView(withId(R.id.recycler_view_meeting_list))
                .perform(actionOnItemAtPosition(2, new DeleteViewAction()));

        onView(withId(R.id.recycler_view_meeting_list))
                .check(matches(hasChildCount(MEETING_LIST_SIZE - 1)));
    }

    @Test
    public void b_filterMeetingByDate() {
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
    public void c_filterMeetingByRoom() {
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
