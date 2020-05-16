package com.lamzone.mareu.Fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private StartTimePickerFragmentCallback mFragmentCallback;

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
       //if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)&&c.get(Calendar.MONTH) == today.get(Calendar.MONTH)&&c.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
       //    if (hourOfDay * 60 + minute < (today.get(Calendar.HOUR_OF_DAY) * 60 + today.get(Calendar.MINUTE)))
       //        Toast.makeText(this.getContext(), "Veuillez entrer une heure de début valide", Toast.LENGTH_LONG).show();
       //    else{
       //        calendar.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), hourOfDay, minute);
       //        editTextStartTime.setText(hourOfDay + ":" + minute);
       //        onStartTimeSelected(hourOfDay, minute);
       //    }
       //}
       //else
       //{
       //    if (calendar.get(Calendar.YEAR) <= today.get(Calendar.YEAR)&&c.get(Calendar.MONTH) <= today.get(Calendar.MONTH)&&c.get(Calendar.DAY_OF_MONTH) < today.get(Calendar.DAY_OF_MONTH))
       //        Toast.makeText(this.getContext(), "Veuillez entrer une heure de début valide", Toast.LENGTH_LONG).show();
       //    else{
       //        calendar.set(calendar.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), hourOfDay, minute);
       //        editTextStartTime.setText(hourOfDay + ":" + minute);
       //        onStartTimeSelected(hourOfDay, minute);
       //    }
       //}
    }

    public interface StartTimePickerFragmentCallback{
        public void onStartTimeSelected(int hour,int minute);
    }

    public void onStartTimeSelected(int hour, int minute){
        mFragmentCallback.onStartTimeSelected(hour,minute);
    }
}




