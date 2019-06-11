package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.content.Context;

import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils;

/**
 * Created by Lmz on 2019/06/11
 */
public class MyApplication extends Application {
    public static  Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context =this;
        SharePresenterUtils.init(this);
    }

    public static Context getContext() {
        return context;
    }
}
