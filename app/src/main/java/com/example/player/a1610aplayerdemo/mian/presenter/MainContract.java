package com.example.player.a1610aplayerdemo.mian.presenter;

import com.example.player.a1610aplayerdemo.mian.bean.UserBean;

public class MainContract {
    public interface IMainGetUserInfo{
        void getUserInfo();
    }
    public interface IMainUserInfoStatus{
        void onSuccssful(UserBean userBean);
        void onFaild(String errInfo);
    }
}
