package com.treebricks.hrmanagement;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.treebricks.hrmanagement.utils.SeasonImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PrimaryDrawerItem home = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        PrimaryDrawerItem attendance = new PrimaryDrawerItem().withIdentifier(2).withName("Attendance");
        PrimaryDrawerItem liveAttendance = new PrimaryDrawerItem().withIdentifier(3).withName("Current Attendance Status");
        PrimaryDrawerItem leaveApplication = new PrimaryDrawerItem().withIdentifier(4).withName("Apply for Leave");
        PrimaryDrawerItem leaveApplicationList = new PrimaryDrawerItem().withIdentifier(5).withName("Leave Applications");
        PrimaryDrawerItem allEmployee = new PrimaryDrawerItem().withIdentifier(5).withName("All Employee");
        PrimaryDrawerItem forum = new PrimaryDrawerItem().withIdentifier(5).withName("Forum");
        PrimaryDrawerItem chat = new PrimaryDrawerItem().withIdentifier(5).withName("Chat");

        PrimaryDrawerItem profile = new PrimaryDrawerItem().withIdentifier(88).withName("Profile");
        PrimaryDrawerItem settings = new PrimaryDrawerItem().withIdentifier(88).withName("Settings");

        List<IDrawerItem> primaryItems = new ArrayList<>();
        primaryItems.add(home);
        primaryItems.add(attendance);
        primaryItems.add(liveAttendance);
        primaryItems.add(leaveApplication);
        primaryItems.add(leaveApplicationList);
        primaryItems.add(allEmployee);
        primaryItems.add(new DividerDrawerItem());
        primaryItems.add(forum);
        primaryItems.add(chat);

        List<IDrawerItem> footerItems = new ArrayList<>();
        footerItems.add(profile);
        footerItems.add(settings);

        ProfileDrawerItem accountProfile = new ProfileDrawerItem()
                .withName("Md. Fahim Shahrier Rasel")
                .withEmail("Developer")
                .withIcon(R.drawable.ic_launcher_foreground);

        AccountHeader accountHeader = new AccountHeaderBuilder().withActivity(this)
                .withHeaderBackground(SeasonImage.getThisSeasonImage(this))
                .addProfiles(accountProfile)
                .build();

        Drawer drawer = new DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withAccountHeader(accountHeader)
            .withDrawerItems(primaryItems)
            .withStickyDrawerItems(footerItems)
            .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                @Override
                public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                    return false;
                }
            }).build();


    }

}
