package com.example.player.a1610aplayerdemo.ui.presenter;

import com.example.player.a1610aplayerdemo.ui.bean.TokenBean;

public class TokenContract {

    public interface ITokenUserInfo{
        void getInfo();
    }

    public interface ITokenInfoStatus{
        void onSuccssful(TokenBean tokenBean);
        void onFaild(String error);
    }

}