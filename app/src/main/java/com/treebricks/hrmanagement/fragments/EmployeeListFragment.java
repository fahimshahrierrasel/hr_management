package com.treebricks.hrmanagement.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.treebricks.hrmanagement.R;
import com.treebricks.hrmanagement.adapters.EmployeeListRecyclerViewAdapter;
import com.treebricks.hrmanagement.adapters.LeaveApplicationRecyclerViewAdapter;
import com.treebricks.hrmanagement.models.ApplicationItem;
import com.treebricks.hrmanagement.models.EmployeeSummery;

import java.util.ArrayList;

public class EmployeeListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragemnt_all_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvAllLeaveApplication  = view.findViewById(R.id.rvAllEmployeeList);

        ArrayList<EmployeeSummery> allApplication = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            allApplication.add(new EmployeeSummery("","Jone Public" + i, "General Worker", "jp@example.com"));
        }
        EmployeeListRecyclerViewAdapter elrva = new EmployeeListRecyclerViewAdapter(getActivity(), allApplication);
        rvAllLeaveApplication.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAllLeaveApplication.setAdapter(elrva);
    }
}
