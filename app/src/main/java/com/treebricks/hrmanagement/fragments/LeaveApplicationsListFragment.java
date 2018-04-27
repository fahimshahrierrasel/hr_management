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
import com.treebricks.hrmanagement.adapters.LeaveApplicationRecyclerViewAdapter;
import com.treebricks.hrmanagement.models.ApplicationItem;

import java.util.ArrayList;

public class LeaveApplicationsListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragemnt_all_leave_applications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvAllLeaveApplication  = view.findViewById(R.id.rvLeaveApplicationsList);

        ArrayList<ApplicationItem> allApplication = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            allApplication.add(new ApplicationItem("Jone Public" + i, "No Reason", i));
        }
        LeaveApplicationRecyclerViewAdapter larva = new LeaveApplicationRecyclerViewAdapter(getActivity(), allApplication);
        rvAllLeaveApplication.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAllLeaveApplication.setAdapter(larva);
    }
}
