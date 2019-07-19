package com.example.player.a1610aplayerdemo;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.umeng.commonsdk.UMConfigure;

public class MyApplication extends Application {
    public static  Context m_context;
    @Override
    public void onCreate() {
        super.onCreate();
        m_context = this;

         UMConfigure.setLogEnabled(true);
         UMConfigure.setEncryptEnabled(true);
         UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE,null);

      
    }


}
