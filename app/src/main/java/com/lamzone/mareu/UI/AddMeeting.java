package com.lamzone.mareu.UI;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Guest;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import java.text.DateFormat;
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

    @BindView(R.id.meeting_date_picker)
    DatePicker mDatePicker;

    //@BindView(R.id.start_time_btn)
    //Button startTimeMeetingButton;

    //@BindView(R.id.end_time_button)
    //Button endTimeMeetingButton;

    @BindView(R.id.guest_email)
    MultiAutoCompleteTextView guestEmail;

    @BindView(R.id.start_time_picker_txt)
    TextView startMeetingTimePicker;
    @BindView(R.id.end_time_picker_txt)
    TextView endMeetingTimePicker;


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
        //startTimePicker();
        //endTimePicker();
        initRoomSpinner();
        autoCompleteGuestEmail();
        setStartTimePicker();
        setEndTimePicker();



        //region RegionDatePicker
        int day = mDatePicker.getDayOfMonth();
        int month = mDatePicker.getMonth();
        int year = mDatePicker.getYear();
        startMeetingCalendar.set(year, month, day);
        //endregion
//



    }

    //ublic void startTimePicker() {
    //   startTimeMeetingButton.setOnClickListener(new View.OnClickListener() {
    //       @Override
    //       public void onClick(View v) {
    //           DialogFragment timePicker = new TimePickerFragment();
    //           timePicker.show(getSupportFragmentManager(), "time picker");
    //       }
    //   });
    //

    //public void endTimePicker() {
    //    endTimeMeetingButton.setOnClickListener(new View.OnClickListener() {
    //        @Override
    //        public void onClick(View view) {
    //            DialogFragment endTimePicker = new TimePickerFragment();
    //            endTimePicker.show(getSupportFragmentManager(), "endTimePicker");
    //        }
    //    });
    //}


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

    //Auto complete view for meeting guest emails
    public void autoCompleteGuestEmail(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Guest.guestList);

        guestEmail.setAdapter(adapter);
        guestEmail.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    private void setStartTimePicker() {
        final TimePickerDialog.OnTimeSetListener startTime = (view, hourOfDay, minute) -> {
            startMeetingCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            startMeetingCalendar.set(Calendar.MINUTE, minute);
            updateStartTimeTextView();
        };
        startMeetingTimePicker.setOnClickListener(v -> new TimePickerDialog(AddMeeting.this,
                startTime, startMeetingCalendar.get(Calendar.HOUR),
                startMeetingCalendar.get(Calendar.MINUTE),
                true).show());
    }

    private void setEndTimePicker(){
        final  TimePickerDialog.OnTimeSetListener endTime = (view, hourOfDay, minute) -> {
            endMeetingCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
            endMeetingCalendar.set(Calendar.MINUTE,minute);
            updateEndTimeTextView();
        };
        endMeetingTimePicker.setOnClickListener(view -> new TimePickerDialog(AddMeeting.this,
                endTime,endMeetingCalendar.get(Calendar.HOUR),
                endMeetingCalendar.get(Calendar.MINUTE),
                true).show());
    }

    private void updateStartTimeTextView() {
        DateFormat timeFormat1 = DateFormat.getTimeInstance(DateFormat.SHORT);
        startMeetingTimePicker.setText(timeFormat1.format(startMeetingCalendar.getTime()));
    }

    private void  updateEndTimeTextView(){
        DateFormat timeFormat2 =DateFormat.getTimeInstance(DateFormat.SHORT) ;
        endMeetingTimePicker.setText(timeFormat2.format(endMeetingCalendar.getTime()));

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
    //@OnClick(R.id.meeting_save)
    //void addMeeting(){
    //    Meeting meeting = new Meeting(
    //            System.currentTimeMillis(),
    //            DummyMeetingGenerator.getActualColor(),
    //            meetingRoomSpinner.getSelectedItem().toString(),
    //            meetingSubject.getText(),
//
//
//
    //    )
    //}

    public void onTextChanged() {
        meetingSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
    }

}