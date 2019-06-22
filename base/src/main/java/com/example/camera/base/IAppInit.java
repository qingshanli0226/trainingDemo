package com.example.camera.base;

import android.app.Application;

public interface IAppInit {
    void init(Application instance);//应用程序启动时会调用各个模块的init方法。
}
