package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.content.Context;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {

    public static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        SpUtil.init(this);

        Fresco.initialize(this);

    }
}
