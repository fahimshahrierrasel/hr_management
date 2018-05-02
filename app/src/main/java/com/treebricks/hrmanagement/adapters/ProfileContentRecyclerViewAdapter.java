package com.treebricks.hrmanagement.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
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
import com.treebricks.hrmanagement.models.ProfileContent;

import java.util.ArrayList;

public class ProfileContentRecyclerViewAdapter extends RecyclerView.Adapter<ProfileContentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ProfileContent> profileContents;

    public ProfileContentRecyclerViewAdapter(Context context, ArrayList<ProfileContent> profileContents) {
        this.context = context;
        this.profileContents = profileContents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_content_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProfileContent profileContent = profileContents.get(position);
        holder.ivContentIcon.setImageDrawable(context.getResources().getDrawable(profileContent.getContentIcon()));
        holder.tvContentValue.setText(profileContent.getContentValue());
        holder.tvContentType.setText(profileContent.getContentType());
    }

    @Override
    public int getItemCount() {
        return profileContents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cvContainer;
        ImageView ivContentIcon;
        TextView tvContentValue;
        TextView tvContentType;

        ViewHolder(View itemView) {
            super(itemView);
            cvContainer = itemView.findViewById(R.id.cvContainer);
            ivContentIcon = itemView.findViewById(R.id.iv_content_icon);
            tvContentValue = itemView.findViewById(R.id.tv_content_value);
            tvContentType = itemView.findViewById(R.id.tv_content_type);
        }
    }
}
