package com.uidynamic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import android.support.v4.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageView img_add_content;
    private ImageView img_content_filter;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Menu mMenuItem;
    private View header;
    ImageView id_settings_bg_image;
    private TextView navAccountInfo;
    private TextView navUserName;
    String mLoginvalue ="",mTheme="";

    SharedPreferences sharedpreferences=null;
    SharedPreferences.Editor editor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utils.onActivityCreateSetTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyrano_home);
        inittheme();
        initViews();
    }

    private void inittheme() {
        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (sharedpreferences.contains("LOGIN")) {
            mLoginvalue=sharedpreferences.getString("LOGIN", "");
        }
        if (sharedpreferences.contains("SETTHEME")) {
            mTheme=sharedpreferences.getString("SETTHEME", "");
        }

        if(mTheme.length()>0 && mTheme.equals("false")){
            if(mLoginvalue.length()>0) {

                if (mLoginvalue.equalsIgnoreCase("admin@hd.com")) {
                    Utils.changeToTheme(this, Utils.THEME_HDNEWS);
                    //editor.clear();
                } else if (mLoginvalue.equalsIgnoreCase("admin@ups.com")) {
                    Utils.changeToTheme(this, Utils.THEME_UPS);
                } else {
                    Utils.changeToTheme(this, Utils.THEME_DEFAULT);
                }
                editor = sharedpreferences.edit();
                editor.putString("SETTHEME", "true"); // Storing string
                editor.apply();
            }
        }
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = toolbar.findViewById(R.id.txt_toolbar_title);
        img_add_content = findViewById(R.id.img_add_content);
        img_content_filter = findViewById(R.id.img_content_filter);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        toolbarTitle.setText("Inbox");
        //setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        mMenuItem = navigationView.getMenu();
        header = navigationView.getHeaderView(0);
        id_settings_bg_image = header.findViewById(R.id.id_settings_bg_image);

        navAccountInfo = header.findViewById(R.id.id_nav_account_info);
        navUserName = header.findViewById(R.id.id_nav_username);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        open();
        mMenuItem.add(R.id.idMenuInbox, getResources().getInteger(R.integer.navigation_drawer_menu_inbox), 0, R.string.nav_inbox).setIcon(R.drawable.nav_list_ic_inbox).setActionView(R.layout.nav_counter_layout);
        mMenuItem.add(R.id.idMenuInbox, getResources().getInteger(R.integer.navigation_drawer_menu_discover_channels), 0, R.string.nav_discover_channel).setIcon(R.drawable.nav_list_ic_discover_channels);
        mMenuItem.add(R.id.idMenuInbox, getResources().getInteger(R.integer.navigation_drawer_menu_directory), 0, R.string.nav_directory).setIcon(R.drawable.nav_list_ic_directory).setActionView(R.layout.nav_counter_layout);
        mMenuItem.add(R.id.idMenuProgram, getResources().getInteger(R.integer.navigation_drawer_menu_programs), 0, R.string.nav_your_programs).setIcon(R.drawable.nav_list_ic_programs);
        mMenuItem.add(R.id.idMenuProgram, getResources().getInteger(R.integer.navigation_drawer_menu_clips), 0, R.string.nav_your_clips).setIcon(R.drawable.nav_list_ic_my_clips);
        mMenuItem.add(R.id.idMenuProgram, getResources().getInteger(R.integer.navigation_drawer_menu_clipsTorecord), 0, R.string.nav_clips_to_reocrd).setIcon(R.drawable.nav_list_ic_sc_programs).setActionView(R.layout.nav_counter_layout);

        setMenuListTypeFace(mMenuItem);
        //int launchFragment = 0;
        //setSelectedMenuItem(launchFragment);
        navigationView.setCheckedItem(getResources().getInteger(R.integer.navigation_drawer_menu_inbox));
        setSelectedMenuItem(getResources().getInteger(R.integer.navigation_drawer_menu_inbox), navigationView.getMenu());


        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                navigationView.setCheckedItem(getResources().getInteger(R.integer.navigation_drawer_menu_inbox));
                setSelectedMenuItem(getResources().getInteger(R.integer.navigation_drawer_menu_inbox), navigationView.getMenu());
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    public void open() {
        drawer.openDrawer(Gravity.LEFT);
    }

    void setSelectedMenuItem(int position, Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).getItemId() == position)
                navigationView.getMenu().getItem(i).setChecked(true);
            else
                navigationView.getMenu().getItem(i).setChecked(false);
        }
    }

    private void setMenuListTypeFace(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem mi = menu.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    //applyFontToMenuItem(subMenuItem);
                }
            }
            //the method we have create in activity

        }
    }
}
