package com.example.player.a1610aplayerdemo.util;

import android.app.Application;

public class MyApplication extends Application{

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
