package com.example.player.a1610aplayerdemo.fragment.MusicClass.present;

import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.MbBean;

public class MusicContact {
    interface MbPresent{
        void getData();
    }
    public interface MbView{
        void getSuccessData(MbBean mbBean);
        void getFailData(String e);
    }
}
