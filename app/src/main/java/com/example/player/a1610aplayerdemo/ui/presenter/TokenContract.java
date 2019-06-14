package com.example.player.a1610aplayerdemo.ui.presenter;

import com.example.player.a1610aplayerdemo.ui.bean.Bean;

public class TokenContract {

    public interface ITokenUserInfo{
        void getInfo();
    }

    public interface ITokenInfoStatus{
        void onSuccssful(Bean bean);
        void onFaild(String error);
    }

}