package com.gradlestuff.adapters;

import android.graphics.drawable.Drawable;

public class AppList {

    private String name,appDesc;
    Drawable icon;

    public AppList(String name,String appDesc, Drawable icon) {
        this.name = name;
        this.appDesc = appDesc;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }
    public String getAppDesc() {
        return appDesc;
    }

    public Drawable getIcon() {
        return icon;
    }
}
