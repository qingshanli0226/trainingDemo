package com.example.player.a1610aplayerdemo.commit;

import android.app.Application;

public class MyApplication extends Application {
    public static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}