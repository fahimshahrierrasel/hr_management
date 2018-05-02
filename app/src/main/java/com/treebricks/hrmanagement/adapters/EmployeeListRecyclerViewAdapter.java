package com.treebricks.hrmanagement.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.treebricks.hrmanagement.R;
import com.treebricks.hrmanagement.fragments.EmployeeDetailsFragment;
import com.treebricks.hrmanagement.models.EmployeeSummery;

import java.util.ArrayList;
import java.util.Locale;

public class EmployeeListRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeListRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<EmployeeSummery> employeeSummeries;

    public EmployeeListRecyclerViewAdapter(Context context, ArrayList<EmployeeSummery> applicationItems) {
        this.context = context;
        this.employeeSummeries = applicationItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_profile_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmployeeSummery employeeSummery = employeeSummeries.get(position);
        holder.tvLeaveApplicantName.setText(employeeSummery.getName());
        holder.tvDesignation.setText(employeeSummery.getDesignation());
        holder.tvEmail.setText(employeeSummery.getEmail());
        holder.cvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, new EmployeeDetailsFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeSummeries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvContainer;
        ImageView ivEmployeeImage;
        TextView tvLeaveApplicantName;
        TextView tvDesignation;
        TextView tvEmail;

        ViewHolder(View itemView) {
            super(itemView);
            cvContainer = itemView.findViewById(R.id.cvLeaveApplicationItem);
            ivEmployeeImage = itemView.findViewById(R.id.iv_employee_image);
            tvLeaveApplicantName = itemView.findViewById(R.id.tv_employee_name);
            tvDesignation = itemView.findViewById(R.id.tv_employee_designation);
            tvEmail = itemView.findViewById(R.id.tv_employee_email);
        }
    }
}
