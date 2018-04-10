package com.gradlestuff;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;//;=null;
    SharedPreferences.Editor editor;//=null;
    String mTheme="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        //if(sharedpreferences!=null) {
        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedpreferences!=null) {
            if (sharedpreferences.contains("SETTHEME")) {
                mTheme =sharedpreferences.getString("SETTHEME", "");
            }/*else{
                mTheme="false";
            }*/
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
            }/*else if(Constants.mClients == Constants.Clients.POGO){
            Log.i("GradleStuff","Pogo Build");
        }*/

        }
    }
}
