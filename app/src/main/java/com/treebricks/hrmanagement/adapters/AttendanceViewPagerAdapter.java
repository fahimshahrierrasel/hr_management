package com.treebricks.hrmanagement.adapters;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.treebricks.hrmanagement.fragments.AttendanceSummeryFragment;

public class AttendanceViewPagerAdapter extends FragmentPagerAdapter {

    public AttendanceViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AttendanceSummeryFragment();
            case 1:
                return new AttendanceSummeryFragment();
            case 2:
                return new AttendanceSummeryFragment();
            default:
                return new AttendanceSummeryFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
