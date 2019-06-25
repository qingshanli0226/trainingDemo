package com.example.player.a1610aplayerdemo.ui.my.login;

import com.example.player.a1610aplayerdemo.bean.SignInBean;

public interface ILoginView {
    void loginSuccess(SignInBean signInBean);
    void loginFail();
    void loginError();
}
