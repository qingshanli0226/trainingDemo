package com.example.player.a1610aplayerdemo;

import android.app.Application;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import com.umeng.commonsdk.UMConfigure;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TokenSp.getInstance().init(this);
        UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE,null);
    }
}
