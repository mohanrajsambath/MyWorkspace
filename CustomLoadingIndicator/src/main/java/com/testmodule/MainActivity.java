package com.testmodule;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

import com.agrawalsuneet.loaderspack.loaders.ArcProgressLoader;
import com.agrawalsuneet.loaderspack.loaders.CircularSticksLoader;
import com.agrawalsuneet.loaderspack.loaders.ClockLoader;
import com.agrawalsuneet.loaderspack.loaders.CurvesLoader;
import com.agrawalsuneet.loaderspack.loaders.FidgetLoader;
import com.agrawalsuneet.loaderspack.loaders.GaugeLoader;
import com.agrawalsuneet.loaderspack.loaders.MultipleRippleLoader;
import com.agrawalsuneet.loaderspack.loaders.PulseLoader;
import com.agrawalsuneet.loaderspack.loaders.RingAndCircleLoader;
import com.agrawalsuneet.loaderspack.loaders.RotatingCircularSticksLoader;
import com.agrawalsuneet.loaderspack.loaders.SearchLoader;
import com.agrawalsuneet.loaderspack.loaders.WifiLoader;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";

    public LinearLayout containterLayout;
    String mreferSite="https://agrawalsuneet.github.io/opensourcecontribution/";
    String mReferenceLink="https://github.com/agrawalsuneet/LoadersPack-Android";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containterLayout =findViewById(R.id.containterLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.e(TAG, "CPU_ABI : " + Build.CPU_ABI);
        Log.e(TAG, "CPU_ABI2 : " + Build.CPU_ABI2);
        Log.e(TAG, "OS.ARCH : " + System.getProperty("os.arch"));

        Log.e(TAG, "SUPPORTED_ABIS : " + Arrays.toString(Build.SUPPORTED_ABIS));
        Log.e(TAG, "SUPPORTED_32_BIT_ABIS : " + Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
        Log.e(TAG, "SUPPORTED_64_BIT_ABIS : " + Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));

        setDifferentLoader();
    }

    private void setDifferentLoader() {
        /*ClockLoader*/
        ClockLoader clockLoader = new ClockLoader(this);
        clockLoader.setOuterCircleBorderWidth(8.0f);
        clockLoader.setBigCircleRadius(150.0f);
        clockLoader.setMinuteHandLength(120.0f);
        clockLoader.setHourHandLength(80.0f);
        clockLoader.setInnerCircleRadius(15.0f);

        clockLoader.setOuterCircleBorderColor(ContextCompat.getColor(this, R.color.colorAccent));
        clockLoader.setBigCircleColor(ContextCompat.getColor(this, R.color.colorPrimary));
        clockLoader.setInnerCircleColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        clockLoader.setHourHandColor(ContextCompat.getColor(this, R.color.colorAccent));
        clockLoader.setMinuteHandColor(ContextCompat.getColor(this, R.color.colorAccent));

        clockLoader.setAnimSpeedMultiplier(0.05f);
        containterLayout.addView(clockLoader);

/*GaugeLoader*/
        /*GaugeLoader gaugeLoader = new GaugeLoader(this, 150, 80,
                20, 50,
                ContextCompat.getColor(this, R.color.blue_delfault),
                ContextCompat.getColor(this, R.color.blue_selected),
                ContextCompat.getColor(this, android.R.color.black), true);

        container.addView(gaugeLoader);*/

        //or you can provide custom rotate animation for needle
        final GaugeLoader gaugeLoader = new GaugeLoader(this, 120, 120,
                15, 20,
                ContextCompat.getColor(this, R.color.blue_delfault),
                ContextCompat.getColor(this, R.color.blue_selected),
                ContextCompat.getColor(this, android.R.color.black), false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RotateAnimation anim = new RotateAnimation(270.0f, 410.0f,
                        gaugeLoader.getNeedlePivotX(), gaugeLoader.getNeedlePivotY());
                anim.setDuration(4000);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                gaugeLoader.startLoading(anim);
            }
        }, 500);

        //delay because view will not be initialized
        containterLayout.addView(gaugeLoader);

/*MultipleRippleLoader*/
        MultipleRippleLoader multipleRippleLoader = new MultipleRippleLoader(this,
                50,
                ContextCompat.getColor(this, R.color.blue_selected),
                4);

        multipleRippleLoader.setFromAlpha(0.9f);
        multipleRippleLoader.setToAlpha(0.2f);
        multipleRippleLoader.setAnimationDuration(3000);
        multipleRippleLoader.setInterpolator(new LinearInterpolator());
        containterLayout.addView(multipleRippleLoader);

/*CurvesLoaders*/
        CurvesLoader curvesLoader = new CurvesLoader(
                this,
                2,
                100,
                5,
                10,
                160.0f,
                ContextCompat.getColor(this, R.color.blue_selected));
        curvesLoader.setAnimDuration(1000);
        /*curvesLoader.setInterpolator(new LinearInterpolator());*/
        curvesLoader.setInterpolator(new BounceInterpolator());
        containterLayout.addView(curvesLoader);

        /*RingAndCircleLoader*/
        RingAndCircleLoader ringAndCircleLoader = new RingAndCircleLoader(
                this,
                10,
                50,
                5,
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.green_default));
        ringAndCircleLoader.setAnimDuration(1000);
        containterLayout.addView(ringAndCircleLoader);

        /*ArcProgressLoader*/
        ArcProgressLoader arcProgressLoader = new ArcProgressLoader(this,
                80, 20,
                10.0f, 140.0f,
                getResources().getIntArray(R.array.colors_rgb));
        containterLayout.addView(arcProgressLoader);

        /*FidgetLoader*/
        FidgetLoader fidgetLoader = new FidgetLoader(this,
                20,
                ContextCompat.getColor(this, R.color.blue_selected),
                ContextCompat.getColor(this, R.color.amber));

        fidgetLoader.setAnimDuration(1500);
        fidgetLoader.setNoOfRotation(10);
        fidgetLoader.setInterpolator(new BounceInterpolator());
        /*fidgetLoader.setInterpolator(new LinearInterpolator());*/
        containterLayout.addView(fidgetLoader);

        /*WifiLoader*/
        WifiLoader wifiLoader = new WifiLoader(this,
                8,
                ContextCompat.getColor(this, R.color.blue_selected));
        wifiLoader.setIncrementalAngle(1.2f);
        containterLayout.addView(wifiLoader);
        /*SearchLoader*/
        SearchLoader searchLoader = new SearchLoader(this,
                60, 20, 80,
                ContextCompat.getColor(this, R.color.blue_selected),
                500, 500, true);
        containterLayout.addView(searchLoader);

        /*PulseLoader*/
        PulseLoader pulseLoader = new PulseLoader(this,
                15,
                500,
                15.0f,
                15.0f,
                ContextCompat.getColor(this, R.color.red));
        containterLayout.addView(pulseLoader);

        /*RotatingCircularSticksLoader*/
        RotatingCircularSticksLoader loader = new RotatingCircularSticksLoader(this,
                9, 50f, 25f,
                ContextCompat.getColor(this, R.color.blue_selected),
                ContextCompat.getColor(this, R.color.white));

        loader.setAnimDuration(5000);
        containterLayout.addView(loader);

        /*CircularSticksLoader*/
        CircularSticksLoader circleStickloader = new CircularSticksLoader(this, 16,
                200f, 150f,
                ContextCompat.getColor(this, R.color.blue_selected),
                ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, android.R.color.white));

        circleStickloader.setShowRunningShadow(true);
        circleStickloader.setFirstShadowColor(ContextCompat.getColor(this, R.color.white));
        circleStickloader.setSecondShadowColor(ContextCompat.getColor(this, R.color.white));
        circleStickloader.setAnimDuration(50);

        containterLayout.addView(circleStickloader);

    }


}
