package com.example.player.a1610aplayerdemo.ui.activity;

import com.example.player.a1610aplayerdemo.bean.LoginUserInfoBean;

/**
 * Created by Lmz on 2019/06/17
 */
public interface LoginView {
    void LoginUserSuccess(LoginUserInfoBean loginUserInfoBean);
    void LoginUserFailure(String error);
}
