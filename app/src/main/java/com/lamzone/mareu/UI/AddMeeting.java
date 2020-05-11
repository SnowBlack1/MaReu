package com.lamzone.mareu.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.textfield.TextInputLayout;
import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AddMeeting extends AppCompatActivity {

   // @BindView(R.id.back_btn)
    //Button backBtn;
    @BindView(R.id.color_meeting)
    ImageView colorMeeting;
    @BindView(R.id.meeting_room_spinner)
    Spinner meetingRoomSpinner;
    @BindView(R.id.meeting_save)
    Button meetingSaveBtn;
    @BindView(R.id.add_meeting_toolbar)
    Toolbar addMeetingToolbar;

    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    Calendar startMeeting = Calendar.getInstance();
    Calendar endMeeting = Calendar.getInstance();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);

       // backBtn.setOnClickListener(v -> finish());
        colorMeeting.setOnClickListener(view -> colorMeeting.setBackgroundColor(DummyMeetingGenerator.generateColor()));

        initRoomSpinner();


        setSupportActionBar(addMeetingToolbar);
        addMeetingToolbar.setNavigationIcon(R.drawable.ic_back_arrow_24dp);
        getSupportActionBar().setTitle("Ajouter une réunion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addMeetingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


       //setSupportActionBar(toolbar);
       //toolbar.setNavigationIcon(R.drawable.ic_back_arrow_24dp);
       //getSupportActionBar().setTitle(null);
       //toolbar.setNavigationOnClickListener(new View.OnClickListener() {
       //    @Override
       //    public void onClick(View view) {
       //        finish();
       //    }
       //});


    }

    //Spinner to choose a Room for a meeting
    public void initRoomSpinner () {
        List<String> spinner = Room.getRoom();
        ArrayAdapter roomArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinner);
        meetingRoomSpinner.setDropDownHorizontalOffset(android.R.layout.simple_dropdown_item_1line);
        meetingRoomSpinner.setAdapter(roomArrayAdapter);
    }





}