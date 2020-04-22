package com.lamzone.mareu.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.MeetingApiService;

import static com.lamzone.mareu.Utils.Constants.MEETING_KEY;

public class MeetingDetails extends AppCompatActivity {

    private MeetingApiService mMeetingApiService;
    Meeting meeting;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);



        meeting = (Meeting) getIntent().getSerializableExtra(MEETING_KEY);
    }
}
