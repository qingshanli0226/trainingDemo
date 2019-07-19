package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.content.Context;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {

    public static Context instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SpUtil.init(this);
        Fresco.initialize(this);
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
/*
注意：如果您已经在AndroidManifest.xml中配置过appkey和channel值，可以调用此版本初始化函数。
*/
        UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE,null);
    }


}
