package com.lamzone.mareu.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use current date as default date in the picker
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),
                day, month, year);
    }

}
