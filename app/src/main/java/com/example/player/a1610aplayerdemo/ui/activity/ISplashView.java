package com.example.player.a1610aplayerdemo.ui.activity;

import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.FirstInBean;
import com.example.player.a1610aplayerdemo.bean.SplashBean;

/**
 * Created by Lmz on 2019/06/11
 */
public interface ISplashView<T> extends IBaseView<T> {
    public void loadSplashSuccess(String bean);

    public void loadSplashFailure(String mess);

}
