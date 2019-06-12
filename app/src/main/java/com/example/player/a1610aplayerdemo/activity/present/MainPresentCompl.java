package com.example.player.a1610aplayerdemo.activity.present;

import com.example.player.a1610aplayerdemo.net.RetrofitCreate;

import java.util.HashMap;

public class MainPresentCompl implements MainPresent.IMainPresent {
    MainPresent.IMainView iMainView;

    public MainPresentCompl(MainPresent.IMainView iMainView) {

        this.iMainView = iMainView;
    }

    @Override
    public void getData() {
        HashMap<String,String> map=new HashMap<>();
//        map.put()
//        RetrofitCreate.getNetApiService().FirstInAndGetToken()
    }
}
