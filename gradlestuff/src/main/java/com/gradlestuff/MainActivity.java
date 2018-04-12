package com.gradlestuff;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gradlestuff.fragment.AppListFragment;
import com.gradlestuff.fragment.SettingsFragment;
import com.gradlestuff.fragment.StoreFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedpreferences;//;=null;
    SharedPreferences.Editor editor;//=null;
    String mLoginvalue ="",mTheme="";
    private TextView txt_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        //initTheme();
        initiViews();

    }

    private void initTheme() {
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
                    Utils.changeToTheme(this, Utils.THEME_HOMEDEPOT);
                    //editor.clear();
                } else if (mLoginvalue.equalsIgnoreCase("admin@ups.com")) {
                    Utils.changeToTheme(this, Utils.THEME_UPS);
                } else {
                    Utils.changeToTheme(this, Utils.THEME_CYRANO);
                }
                editor = sharedpreferences.edit();
                editor.putString("SETTHEME", "true"); // Storing string
                editor.apply();
            }
        }
    }

    private void initiViews() {
        txt_home=(TextView)findViewById(R.id.txt_home);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.app_desc), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView=navigationView.getHeaderView(0);
        LinearLayout sideNavLayout = (LinearLayout)headerView.findViewById(R.id.nav_header_main);
        sideNavLayout.setBackgroundResource(R.color.material_gray_800);
        ImageView drawerImage = (ImageView) headerView.findViewById(R.id.drawer_image);
        TextView drawerUsername = (TextView) headerView.findViewById(R.id.drawer_username);
        TextView drawerAccount = (TextView) headerView.findViewById(R.id.drawer_account);
        //drawerImage.setImageDrawable(R.drawable.ic_user);
        //drawerImage.setBackgroundResource(R.drawable.side_nav_bar);
        drawerImage.setImageResource(R.mipmap.ic_launcher_round);
        drawerUsername.setText("User");
        drawerAccount.setText("user@gmail.com");
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Logout Functionality
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            /*editor = sharedpreferences.edit();
            editor.clear();
            editor.apply();*/
            gotoActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedFragment(item.getItemId());
        return true;
    }

    private void displaySelectedFragment(int menuItemId) {
        Fragment fragment = null;
        switch (menuItemId) {
            case R.id.nav_store:
                txt_home.setVisibility(View.GONE);
                fragment = new StoreFragment();
                break;
            case R.id.nav_app_list:
                txt_home.setVisibility(View.GONE);
                fragment = new AppListFragment();
                break;
            case R.id.nav_settings:
                txt_home.setVisibility(View.GONE);
                fragment = new SettingsFragment();
                break;
            default:
                //txt_home.setVisibility(View.VISIBLE);
                break;
        }

        //replace the current fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void gotoActivity() {
        Intent io = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(io);
        finish();
    }
}
    /*private void initTheme() {
        //if(sharedpreferences!=null) {
        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedpreferences!=null) {
            if (sharedpreferences.contains("SETTHEME")) {
                mTheme =sharedpreferences.getString("SETTHEME", "");
            }*//*else{
                mTheme="false";
            }*//*
        }
        if(mTheme.length()==0 && mTheme.equals("")) {
            //if(sharedpreferences==null) {
            sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            editor = sharedpreferences.edit();
            editor.putString("SETTHEME", "true"); // Storing string
            editor.apply();
            //}

            if (Constants.mClients == Constants.Clients.HOMEDEPOT) {
                Log.i("GradleStuff", "HomeDepot Build");
                Utils.changeToTheme(this, Utils.THEME_HOMEDEPOT);
            } else if (Constants.mClients == Constants.Clients.UPS) {
                Log.i("GradleStuff", "UPS Build");
                Utils.changeToTheme(this, Utils.THEME_UPS);
            }*//*else if(Constants.mClients == Constants.Clients.POGO){
            Log.i("GradleStuff","Pogo Build");
        }*//*

        }
    }*/