package com.example.player.a1610aplayerdemo.service;

import android.app.Application;
import com.mob.MobSDK;

public class MyApplication extends Application {
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        MobSDK.init(this);

    }
}
