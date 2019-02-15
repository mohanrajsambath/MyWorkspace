package com.mythemeapp

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

import android.app.Activity
import android.content.Intent

object Utils {
    private var sTheme: Int = 0

    val THEME_DEFAULT = 0
    val THEME_HD = 1
    val THEME_UPS = 2

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    fun changeToTheme(activity: Activity, theme: Int) {
        sTheme = theme
        activity.finish()
        activity.startActivity(Intent(activity, activity.javaClass))

    }

    /** Set the theme of the activity, according to the configuration.  */
    fun onActivityCreateSetTheme(activity: Activity) {
        when (sTheme) {
            THEME_DEFAULT -> activity.setTheme(R.style.AppTheme)
            THEME_HD -> activity.setTheme(R.style.BaseTheme_Orange)
            THEME_UPS -> activity.setTheme(R.style.BaseTheme_Lime)
        }
    }
}
