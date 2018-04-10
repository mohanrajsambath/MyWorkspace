package com.gradlestuff;

 /*
 * Copyright (c) 2018. Created by Mohanraj.S, on 20/3/18 for MyWorkspace
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_CYRANO = 0;
    public final static int THEME_HOMEDEPOT = 1;
    public final static int THEME_UPS = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            case THEME_CYRANO:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_HOMEDEPOT:
                activity.setTheme(R.style.HomedepotAppTheme);
                break;
            case THEME_UPS:
                activity.setTheme(R.style.UpsAppTheme);
                break;
        }
    }
}
