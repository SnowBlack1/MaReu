package com.lamzone.mareu.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.events.DeleteMeetingEvent;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetingListActivity extends AppCompatActivity {

    private MeetingApiService mApiService;

    private List<Meeting> mMeetings = new ArrayList<>();
    private List<Room> mRooms = new ArrayList<>();
    private MeetingRecyclerViewAdapter mAdapter;

    @BindView(R.id.recycler_view_meeting_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.add_meeting)
    FloatingActionButton addMeeting;
    @BindView(R.id.meeting_list_toolbar)
    Toolbar meetingListToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.bind(this);
        setSupportActionBar(meetingListToolbar);

        mApiService = DI.getMeetingApiService();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MeetingRecyclerViewAdapter(mMeetings);
        mRecyclerView.setAdapter(mAdapter);

        initMeetingList();
        intentAddMeetingActivity();
    }

    private void initMeetingList() {
        mMeetings = mApiService.getMeetings();
        mRooms = mApiService.getRooms();
        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(mMeetings));
    }
    private void initListDate(Date date) {
        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(mApiService.getMeetingByDateFilter(date)));
    }


    private void intentAddMeetingActivity() {
        addMeeting.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AddMeeting.class);
            startActivity(intent);
        });
    }

    private void initList(String room) {
        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(mApiService.getMeetingByRoomFilter(room)));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meeting_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.filterDate:
                filterDate();
                break;
            case R.id.filterLocation:
                filterRoom();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void filterDate() {
        final AlertDialog.Builder builderDatePicker = new AlertDialog.Builder(this);
        DatePicker picker = new DatePicker(this);
        picker.setCalendarViewShown(false);
        builderDatePicker.setView(picker);

        builderDatePicker.setPositiveButton("OK", (dialog, which) -> {
            int year = picker.getYear();
            int month = picker.getMonth();
            int day = picker.getDayOfMonth();
            Date date = new GregorianCalendar(year, month, day).getTime();
            initListDate(date);
        });
        builderDatePicker.setNegativeButton("Reset", (dialog, whichButton) -> initMeetingList());
        builderDatePicker.show();
    }

    public void filterRoom() {
        List<String> roomList = Room.getRoom();
        String[] roomArray = new String[roomList.size()];
        roomArray = roomList.toArray(roomArray);
        final String[] room = new String[1];
        final AlertDialog.Builder builderRoom = new AlertDialog.Builder(this);
        builderRoom.setTitle("Choisissez une Salle");

        String[] finalRoomList = roomArray;

        builderRoom.setSingleChoiceItems(roomArray, -1, (dialog, which) -> room[0] = finalRoomList[which]);

        builderRoom.setPositiveButton("OK", (dialogInterface, i) -> initList(room[0]));

        builderRoom.setNegativeButton("Reset", (dialog, whichButton) -> initMeetingList());

        AlertDialog dialogRoom = builderRoom.create();

        dialogRoom.show();
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onDeleteMeetingEvent(DeleteMeetingEvent deleteMeetingEvent) {
        mApiService.deleteMeeting(deleteMeetingEvent.meeting);
        initMeetingList();
    }

}
