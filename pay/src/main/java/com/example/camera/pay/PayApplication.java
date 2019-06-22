package com.example.camera.pay;

import android.app.Application;
import com.example.camera.base.IAppInit;
import com.example.camera.base.ServiceManager;

public class PayApplication extends Application implements IAppInit {
    public static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    @Override
    public void init(Application instance) {
         this.instance = instance;
         //将完成的支付功能注册到base模块.
        ServiceManager.getInstance().setiPayService(new PayService());
    }
}
