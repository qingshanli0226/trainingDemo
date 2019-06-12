package com.example.player.a1610aplayerdemo;

import android.app.Application;

public class MVPApplication extends Application {
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
