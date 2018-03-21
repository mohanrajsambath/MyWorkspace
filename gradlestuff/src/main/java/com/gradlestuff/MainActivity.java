package com.gradlestuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Constants.mClients == Constants.Clients.CARTOON){
            Log.i("GradleStuff","Cartoon Build");
        }else if(Constants.mClients == Constants.Clients.DISNEY){
            Log.i("GradleStuff","Disney Build");
        }else if(Constants.mClients == Constants.Clients.POGO){
            Log.i("GradleStuff","Pogo Build");
        }
    }
}
