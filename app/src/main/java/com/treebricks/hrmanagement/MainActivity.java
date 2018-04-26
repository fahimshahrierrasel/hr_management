package com.treebricks.hrmanagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.treebricks.hrmanagement.fragments.AttendanceFragment;
import com.treebricks.hrmanagement.fragments.HomeFragment;
import com.treebricks.hrmanagement.fragments.LeaveApplicationFragment;
import com.treebricks.hrmanagement.utils.SeasonImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Fragment currentFragment;
    private Drawer navigationDrawer;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNavigationDrawer();

        fragmentManager = getSupportFragmentManager();
        currentFragment = new HomeFragment();
        setCurrentFragment(currentFragment);

        navigationDrawer.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                int item = (int) drawerItem.getIdentifier();
                switch (item)
                {
                    case 1:
                        currentFragment = new HomeFragment();
                        break;
                    case 2:
                        currentFragment = new AttendanceFragment();
                        break;
                    case 3:

                        break;
                    case 4:
                        currentFragment = new LeaveApplicationFragment();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    default:
                        currentFragment = new HomeFragment();
                        break;
                }
                setCurrentFragment(currentFragment);
                return false;
            }
        });
    }

    private void setCurrentFragment(Fragment currentFragment)
    {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_placeholder, currentFragment)
                .commit();
    }

    private void setNavigationDrawer() {
        PrimaryDrawerItem home = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        PrimaryDrawerItem attendance = new PrimaryDrawerItem().withIdentifier(2).withName("Attendance");
        PrimaryDrawerItem liveAttendance = new PrimaryDrawerItem().withIdentifier(3).withName("Current Present Status");
        PrimaryDrawerItem leaveApplication = new PrimaryDrawerItem().withIdentifier(4).withName("Apply for Leave");
        PrimaryDrawerItem leaveApplicationList = new PrimaryDrawerItem().withIdentifier(5).withName("Leave Applications");
        PrimaryDrawerItem allEmployee = new PrimaryDrawerItem().withIdentifier(6).withName("All Employee");
        PrimaryDrawerItem forum = new PrimaryDrawerItem().withIdentifier(7).withName("Forum");
        PrimaryDrawerItem chat = new PrimaryDrawerItem().withIdentifier(8).withName("Chat");

        PrimaryDrawerItem profile = new PrimaryDrawerItem().withIdentifier(9).withName("Profile");
        PrimaryDrawerItem settings = new PrimaryDrawerItem().withIdentifier(10).withName("Settings");

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

        AccountHeader accountHeader = new AccountHeaderBuilder().withActivity(MainActivity.this)
                .withHeaderBackground(SeasonImage.getThisSeasonImage(MainActivity.this))
                .addProfiles(accountProfile)
                .build();

        navigationDrawer = new DrawerBuilder()
                .withActivity(MainActivity.this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withDrawerItems(primaryItems)
                .withStickyDrawerItems(footerItems)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
