package com.example.player.a1610aplayerdemo;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
