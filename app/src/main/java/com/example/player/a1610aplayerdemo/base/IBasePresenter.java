package com.example.player.a1610aplayerdemo.base;

import com.example.player.a1610aplayerdemo.ui.activity.SplashActivity;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Lmz on 2019/06/10
 *  base presenter
 */
public interface IBasePresenter<R> {
    void getData(); //在列表展示数据
    void attachView(IBaseView<R> view);//绑定view
    void detachView(); //当View销毁时，注销绑定

}
