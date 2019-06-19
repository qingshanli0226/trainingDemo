package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.support.multidex.MultiDex;
import com.example.player.a1610aplayerdemo.activity.Slaphe.SharePresenterUtils;

public class MyApp extends Application {
    public static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        SharePresenterUtils.init(this);
        MultiDex.install(this);

    }
}
