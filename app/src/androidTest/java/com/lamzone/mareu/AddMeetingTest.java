package com.lamzone.mareu;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lamzone.mareu.UI.MeetingListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
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




}
