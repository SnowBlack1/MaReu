package com.lamzone.mareu.Fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import com.lamzone.mareu.R;

import java.util.Calendar;

import butterknife.BindView;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    //private StartTimePickerFragmentCallback mFragmentCallback;
    public static Calendar calendar = null;
    public static final Calendar today = Calendar.getInstance();

    @BindView(R.id.start_time_picker_txt)
    TextView startMeetingTimePicker;

    @BindView(R.id.end_time_picker_txt)
    TextView endMeetingTimePicker;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Current time is the default value displayed on the time picker
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        //Do sth w/ time chosen by user
    }
}

//public interface StartTimePickerFragmentCallback{
//    public void onStartTimeSelected(int hour,int minute);
//}
//
//public void onStartTimeSelected(int hour, int minute){
//    mFragmentCallback.onStartTimeSelected(hour,minute);
//}






