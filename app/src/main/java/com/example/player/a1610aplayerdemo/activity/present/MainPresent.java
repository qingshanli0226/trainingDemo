package com.example.player.a1610aplayerdemo.activity.present;

public class MainPresent {
    interface IMainPresent{
        void getData();

    }
    interface IMainView{
        void getSuccessData(NetBean netBean);
        void getFail(String e);
    }
}
