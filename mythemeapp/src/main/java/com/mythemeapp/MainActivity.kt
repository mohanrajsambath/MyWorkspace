package com.mythemeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    internal var mLoginvalue: String? = ""
    internal var mTheme: String? = ""

    internal var sharedpreferences: SharedPreferences? = null
    internal var editor: SharedPreferences.Editor? = null
    private val nav_header_imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)
        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        if (sharedpreferences!!.contains("LOGIN")) {
            mLoginvalue = sharedpreferences!!.getString("LOGIN", "")
        }
        if (sharedpreferences!!.contains("SETTHEME")) {
            mTheme = sharedpreferences!!.getString("SETTHEME", "")
        }

        if (mTheme!!.length > 0 && mTheme == "false") {
            if (mLoginvalue!!.length > 0) {

                if (mLoginvalue!!.equals("admin@hd.com", ignoreCase = true)) {
                    Utils.changeToTheme(this, Utils.THEME_HD)
                    //editor.clear();
                } else if (mLoginvalue!!.equals("admin@ups.com", ignoreCase = true)) {
                    Utils.changeToTheme(this, Utils.THEME_UPS)
                } else {
                    Utils.changeToTheme(this, Utils.THEME_DEFAULT)
                }
                editor = sharedpreferences!!.edit()
                editor!!.putString("SETTHEME", "true") // Storing string
                editor!!.apply()
            }
        }

        initViews()

    }

    private fun initViews() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            editor = sharedpreferences!!.edit()
            editor!!.clear()
            editor!!.apply()
            gotoActivity()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun gotoActivity() {
        val io = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(io)
        finish()
    }

    /*@Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        if(mLoginvalue.equalsIgnoreCase("joseph@mailinator.com")){
            theme.applyStyle(R.style.CartoonAppTheme, true);
            System.out.println("CartoonApp Theme Applicable");
        }
        // you could also use a switch if you have many themes that could apply
        return theme;
    }*/
}
