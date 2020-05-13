package com.lamzone.mareu.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lamzone.mareu.DI.DI;
import com.lamzone.mareu.R;
import com.lamzone.mareu.events.DeleteMeetingEvent;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Room;
import com.lamzone.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;
    private final List<Room> mRooms;
    private MeetingApiService mApiService;

    public MeetingRecyclerViewAdapter(List<Meeting> items, List<Room> rooms) {
        mMeetings = items;
        mRooms = rooms;
    }

    @Override
    public MeetingRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meeting_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingRecyclerViewAdapter.ViewHolder holder, int position) {
        mApiService = DI.getMeetingApiService();

        Meeting meeting = mMeetings.get(position);
        holder.meetingColor.setColorFilter(meeting.getColor());
        holder.mMeetingInfos.setText(meeting.getInfo());
        holder.mMeetingEmail.setText(meeting.getGuestList());


        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });



    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { // voir pour viewBinding pour les elements de l'item
        @BindView(R.id.item_list_color)
        public ImageView meetingColor;

        @BindView(R.id.item_list_meeting_infos)
        public TextView mMeetingInfos;

        @BindView(R.id.item_list_email)
        public TextView mMeetingEmail;

        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
