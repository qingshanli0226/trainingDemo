package com.example.compontentlibrary;

import android.app.Application;
import android.content.Context;
import com.example.camera.base.IAppInit;
import com.example.camera.base.ServiceManager;

public class LoginApplication extends Application implements IAppInit {
    public static Application instance;

    //该函数是在当login模块作为应用执行的时候才被调用
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    //该init被调用。有两种情况。一种是当该模块作为应用执行时。 还有一种情况，是自己作为库，但是该方法将被app的application调用.
    @Override
    public void init(Application instance) {
        this.instance = instance;

        //做功能注册，将实现的功能注册到base模块.
        ServiceManager.getInstance().setiLoginService(new LoginService());
    }
}
