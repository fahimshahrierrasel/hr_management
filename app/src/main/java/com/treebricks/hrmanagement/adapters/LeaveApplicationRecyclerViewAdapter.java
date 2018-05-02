package com.treebricks.hrmanagement.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.treebricks.hrmanagement.R;
import com.treebricks.hrmanagement.fragments.LeaveApplicationDetailsFragment;
import com.treebricks.hrmanagement.models.ApplicationItem;
import java.util.ArrayList;
import java.util.Locale;

public class LeaveApplicationRecyclerViewAdapter extends RecyclerView.Adapter<LeaveApplicationRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ApplicationItem> applicationItems;

    public LeaveApplicationRecyclerViewAdapter(Context context, ArrayList<ApplicationItem> applicationItems) {
        this.context = context;
        this.applicationItems = applicationItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.leave_application_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ApplicationItem applicationItem = applicationItems.get(position);
        holder.tvLeaveApplicantName.setText(applicationItem.getApplicantName());
        holder.tvLeaveType.setText(applicationItem.getLeaveType());
        holder.tvTotalLeaveDays.setText(String.format(Locale.US,"%d days", applicationItem.getTotalLeave()));
        holder.cvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, new LeaveApplicationDetailsFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return applicationItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cvContainer;
        TextView tvLeaveApplicantName;
        TextView tvLeaveType;
        TextView tvTotalLeaveDays;

        ViewHolder(View itemView) {
            super(itemView);
            cvContainer = itemView.findViewById(R.id.cvLeaveApplicationItem);
            tvLeaveApplicantName = itemView.findViewById(R.id.tv_employee_name);
            tvLeaveType = itemView.findViewById(R.id.tvLeaveType);
            tvTotalLeaveDays = itemView.findViewById(R.id.tvTotalLeaveDays);
        }
    }
}
