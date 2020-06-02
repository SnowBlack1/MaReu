package com.lamzone.mareu;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lamzone.mareu.UI.MeetingListActivity;

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
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.lamzone.mareu.Utils.Constants.MEETING_LIST_SIZE;
import static com.lamzone.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)

public class AddMeetingTest {

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule =
            new ActivityTestRule<>(MeetingListActivity.class);

    @Before
    public void setUp() {
        MeetingListActivity activity = mActivityTestRule.getActivity();
        assertThat(activity, notNullValue());
    }


    @Test
    public void e_addMeetingWithSuccess() {

        //Checking that items count is equal to MEETING_LIST_SIZE
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
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(16, 0));
        onView(withText("OK")).perform(click());

        // Room choice
        onView(withId(R.id.meeting_room_spinner))
                .perform(click());
        onData(anything()).atPosition(3).perform(click());

        // Enter of meeting guest email
        onView(withId(R.id.guest_email))
                .perform(click())
                .perform(typeText("fire"));

        // Click on the creation button for a new meeting
        onView(withId(R.id.meeting_save)).perform(scrollTo(), click());
        onView(withId(R.id.meeting_save)).perform(scrollTo(), click());


        // Checking that count of items is equal to MEETING_LIST_SIZE +1
        onView(withId(R.id.recycler_view_meeting_list)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view_meeting_list)).check(withItemCount(MEETING_LIST_SIZE + 1));
    }

}
