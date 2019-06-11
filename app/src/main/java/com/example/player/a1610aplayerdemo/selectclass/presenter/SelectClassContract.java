package com.example.player.a1610aplayerdemo.selectclass.presenter;

public class SelectClassContract {
    public interface ISelelctDataPresenter{
        void getSelectBean();
    }

    public interface ISelectDataStatus{
        void onSuccssful();
        void onFaild();
    }
}
