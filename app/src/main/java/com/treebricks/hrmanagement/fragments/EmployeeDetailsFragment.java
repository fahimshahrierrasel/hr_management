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
import com.treebricks.hrmanagement.adapters.ProfileContentRecyclerViewAdapter;
import com.treebricks.hrmanagement.models.ProfileContent;

import java.util.ArrayList;

public class EmployeeDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvAllLeaveApplication  = view.findViewById(R.id.rv_employee_info);

        ArrayList<ProfileContent> allApplication = new ArrayList<>();

        allApplication.add(new ProfileContent(R.drawable.ic_call_black_24dp, "+8801555555555", "Mobile"));
        allApplication.add(new ProfileContent(R.drawable.ic_mail_black_24dp, "jp@example.com", "Email"));
        allApplication.add(new ProfileContent(R.drawable.ic_location_black_24dp, "111-A Lorem Ipsum, Lorem Ipsum, Lorem Ipsum", "Present Address"));
        allApplication.add(new ProfileContent(R.drawable.ic_location_black_24dp, "111-A Lorem Ipsum, Lorem Ipsum, Lorem Ipsum", "Permanent Address"));

        ProfileContentRecyclerViewAdapter elrva = new ProfileContentRecyclerViewAdapter(getActivity(), allApplication);
        rvAllLeaveApplication.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAllLeaveApplication.setAdapter(elrva);
    }
}
