package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    public static  Context m_context;
    @Override
    public void onCreate() {
        super.onCreate();
        m_context = this;
    }
}
