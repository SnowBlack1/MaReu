package com.lamzone.mareu;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lamzone.mareu.UI.MeetingListActivity;
import com.lamzone.mareu.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingListTestInstrumented {

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule =
            new ActivityTestRule(MeetingListActivity.class);

    @Before
    public void setUp() {
        MeetingListActivity activity = mActivityTestRule.getActivity();
        assertThat(activity, notNullValue());
    }

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
                .check(matches(hasChildCount(ITEMS_COUNT -1)));
    }

   //@Test
   //public void addMeetingWithSuccess() {
   //    int meetingCount = DI.getMeetingApiService().getMeeting().size();

   //    onView(withId(R.id.recycler_view_meeting_list)).check(matches(hasChildCount(meetingCount)));

   //    Calendar cal = Calendar.getInstance();
   //    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
   //    String dayOfMonthStr = String.valueOf(dayOfMonth);

   //    onView(withId(R.id.add_meeting))
   //            .perform(click());

   //    onView(withId(R.id.color_meeting))
   //            .check(matches(isDisplayed()));

   //    onView(allOf(withClassName(is("android.widget.NumberPicker$CustomEditText")), withText(dayOfMonthStr), isDisplayed())).perform(replaceText(String.valueOf(dayOfMonth + 7)));

   //    onView(withId(R.id.meeting_subject_txt)).perform(scrollTo(), replaceText("testInstrumented"), closeSoftKeyboard());

   //    onView(allOf(withId(R.id.meeting_save), withText("Save"))).perform(scrollTo(), click());

   //    onView(withId(R.id.recycler_view_meeting_list)).check(matches(isDisplayed()));

   //    onView(withId(R.id.recycler_view_meeting_list)).check(matches(hasChildCount(meetingCount + 1)));
   //}
}
