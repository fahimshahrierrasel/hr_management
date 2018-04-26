package com.treebricks.hrmanagement.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.treebricks.hrmanagement.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LeaveApplicationFragment extends Fragment {

    private static final String TAG = LeaveApplicationFragment.class.getSimpleName();
    private EditText etLeaveStart;
    private EditText etLeaveEnd;
    private EditText etTotalLeaves;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_leave_application, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etLeaveStart = view.findViewById(R.id.etLeaveStart);
        etLeaveEnd = view.findViewById(R.id.etLeaveEnd);
        etTotalLeaves = view.findViewById(R.id.etLeaveDays);
        Button btnLeaveStart = view.findViewById(R.id.btn_leave_start);
        Button btnLeaveEnd = view.findViewById(R.id.btn_leave_end);

        final Calendar myCalendar = Calendar.getInstance();
        String dateFormat = "dd-MM-yyyy";

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);

        long currentDate = System.currentTimeMillis();
        String dateString = simpleDateFormat.format(currentDate);
        etLeaveStart.setText(dateString);
        etLeaveEnd.setText(dateString);
        calculateTotalLeaveDays();

        btnLeaveStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        if (myCalendar.getTime().after(Calendar.getInstance().getTime()))
                            etLeaveStart.setText(simpleDateFormat.format(myCalendar.getTime()));
                        else
                            Toast.makeText(getActivity(), "Don't you know Time Machine is not invented yet!", Toast.LENGTH_LONG).show();
                        calculateTotalLeaveDays();
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnLeaveEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        try {
                            Date firstDate = simpleDateFormat.parse(etLeaveStart.getText().toString());

                            if (myCalendar.getTime().after(firstDate)) {
                                etLeaveEnd.setText(simpleDateFormat.format(myCalendar.getTime()));
                                calculateTotalLeaveDays();
                            } else {
                                Toast.makeText(getActivity(), "Sorry, It is out of my scope. I can do this if you have Time Machine ;)", Toast.LENGTH_LONG).show();
                            }
                        } catch (ParseException e) {
                            Log.d(TAG, "onDateSet: "+e.getMessage());
                        }
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.leave_application_menu, menu);
    }

    private void calculateTotalLeaveDays() {
        long difference = 0L;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        try {
            String startDate = etLeaveStart.getText().toString();
            String endDate = etLeaveEnd.getText().toString();

            Date firstDate = sdf.parse(startDate);
            Date secondDate = sdf.parse(endDate);

            long diffInMillis = Math.abs(secondDate.getTime() - firstDate.getTime());
            difference = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            etTotalLeaves.setText(String.format(Locale.US, "%d days ", difference));
        } catch (ParseException e) {
            Log.d(TAG, "totalLeaveDays: " + e.getMessage());
            etTotalLeaves.setText(String.format(Locale.US, "%d days ", difference));
        }
    }
}
