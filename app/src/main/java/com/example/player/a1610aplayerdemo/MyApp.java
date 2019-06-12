package com.example.player.a1610aplayerdemo;

import android.app.Application;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {

    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        SpUtil.init(this);

        Fresco.initialize(this);

    }
}
