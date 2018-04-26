package com.treebricks.hrmanagement.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.treebricks.hrmanagement.R;
import com.treebricks.hrmanagement.adapters.AttendanceViewPagerAdapter;

public class AttendanceFragment extends Fragment {

    private static final String TAG = AttendanceFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attendance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager pager = view.findViewById(R.id.attendanceViewPager);
        pager.setAdapter(new AttendanceViewPagerAdapter(getChildFragmentManager()));
    }
}
