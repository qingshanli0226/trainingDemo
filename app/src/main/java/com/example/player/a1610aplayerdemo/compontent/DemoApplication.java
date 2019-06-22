package com.example.player.a1610aplayerdemo.compontent;

import android.app.Application;
import com.example.camera.base.IAppInit;
import com.example.camera.base.ModuleConfig;

public class DemoApplication extends Application {
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        
        initCompontentModule();
    }

    //调用各个组件模块的初始化函数，在这些函数里，各个模块会把自己完成的功能注册到base模块，并且将应用程序的上下文传递到各个模块
    private void initCompontentModule() {
        for(String moduleName:ModuleConfig.moduleNames) {
            try {
                Class<?> clazz = Class.forName(moduleName);
                Object object = clazz.newInstance();
                if (object instanceof IAppInit) {
                    IAppInit iAppInit = (IAppInit)object;
                    iAppInit.init(instance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
