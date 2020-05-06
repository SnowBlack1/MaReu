package com.lamzone.mareu.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.lamzone.mareu.R;
import com.lamzone.mareu.service.MeetingApiService;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AddMeeting extends AppCompatActivity {
    
    @BindView(R.id.back_btn)
    Button backBtn;

    
    private MeetingApiService mMeetingApiService;
    
    
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);

        backBtn.setOnClickListener(v -> finish());

        

    }




}