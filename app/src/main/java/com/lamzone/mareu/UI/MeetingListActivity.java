package com.lamzone.mareu.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.MeetingApiService;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        ButterKnife.bind(this);
        //int theme = R.style.AppTheme_NOACTIONBAR;
        //setTheme(theme);

        mApiService = DI.getMeetingApiService();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MeetingRecyclerViewAdapter(mMeetings, mRooms);
        mRecyclerView.setAdapter(mAdapter);

        addMeeting.setOnClickListener(v ->{
            Intent intent = new Intent(v.getContext(),AddMeeting.class);
            startActivity(intent);
        });


        initList();


    }

    private void initList(){
        mMeetings = mApiService.getMeetings();
        mRooms = mApiService.getRooms();
        mRecyclerView.setAdapter(new MeetingRecyclerViewAdapter(mMeetings, mRooms));
    }


   // @OnClick(R.id.add_meeting)
    //void addNeighbour() {
        //AddMeeting.navigate(this);

}
