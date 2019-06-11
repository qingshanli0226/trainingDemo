package com.example.player.a1610aplayerdemo.fragment.Home.present;

import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;

public class SelectPresenter {
    interface ISelectPresener{
        void getSelectorData();
        void DetachView();
    }
    interface ISelectorView{
        void OnGetDataSuccess(SelectorBean selectorBean);
        void onGetDataFail(String e);
    }
}
