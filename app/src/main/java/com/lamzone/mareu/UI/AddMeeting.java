package com.lamzone.mareu.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

;


public class AddMeeting extends AppCompatActivity {


    @BindView(R.id.color_meeting)
    ImageView colorMeeting;

    @BindView(R.id.meeting_room_spinner)
    Spinner meetingRoomSpinner;

    @BindView(R.id.meeting_save)
    Button meetingSaveBtn;

    @BindView(R.id.add_meeting_toolbar)
    Toolbar addMeetingToolbar;

    @BindView(R.id.meeting_subject_txt)
    EditText meetingSubject;

    @BindView(R.id.start_time_btn)
    Button startTimeMeetingButton;

    @BindView(R.id.end_time_button)
    Button endTimeMeetingButton;

    @BindView(R.id.guest_email)
    MultiAutoCompleteTextView guestEmail;


    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    Calendar startMeetingCalendar = Calendar.getInstance();
    Calendar endMeetingCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);


        colorMeeting.setOnClickListener(view -> colorMeeting.setBackgroundColor(DummyMeetingGenerator.generateColor()));

        initToolbar();
        startTimePicker();
        endTimePicker();
        initRoomSpinner();




        //auto complete view -> guests emails
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Guest.guestList);

        guestEmail.setAdapter(adapter);
        guestEmail.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }

    public void startTimePicker() {
        startTimeMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    public void endTimePicker() {
        endTimeMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment endTimePicker = new TimePickerFragment();
                endTimePicker.show(getSupportFragmentManager(), "endTimePicker");
            }
        });
    }


    public void initToolbar() {
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
    }

    //Spinner to choose a Room for a meeting
    public void initRoomSpinner() {
        List<String> spinner = Room.getRoom();
        ArrayAdapter roomArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinner);
        meetingRoomSpinner.setDropDownHorizontalOffset(android.R.layout.simple_dropdown_item_1line);
        meetingRoomSpinner.setAdapter(roomArrayAdapter);
    }


    //@OnClick(R.id.meeting_save)
    //void addMeeting(){
    //   guest = new Guest("1","","","");
    //    List<Participant> participantMeetingList = new ArrayList<>();
    //    String participants = mParticipants.getText().toString();
    //    List<String> allParticipants = Arrays.asList(participants.split("",10));
    //    for (String string:allParticipants){
    //        Guest guest= new Guest("0");
    //        participantMeetingList.add(guest);
    //    }
    //    Meeting meeting = new Meeting (
    //            startTimePicker().getText().toString(),
    //            endTimePicker().getText().toString();
    //            meetingRoomSpinner.getSelectedItem().toString(),
    //            meetingSubject.getText().toString(),
    //            participantMeetingList);
    //    mMeetingApiService.createMeeting(meeting);
    //    finish();
    //}


}