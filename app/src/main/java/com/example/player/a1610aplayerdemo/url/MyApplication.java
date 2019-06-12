package com.example.player.a1610aplayerdemo.url;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {
    public static Application instance;
    public static SharedPreferences preferences;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        preferences=getSharedPreferences("token",MODE_PRIVATE);
    }
}
