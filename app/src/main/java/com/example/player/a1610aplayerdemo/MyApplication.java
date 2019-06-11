package com.example.player.a1610aplayerdemo;

import android.app.Application;
import com.example.player.a1610aplayerdemo.utils.TokenSp;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TokenSp.getInstance().init(this);
    }
}
