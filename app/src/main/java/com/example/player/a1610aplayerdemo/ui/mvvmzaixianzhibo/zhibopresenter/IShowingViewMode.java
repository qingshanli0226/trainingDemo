package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter;

public interface IShowingViewMode {
    void getZiBoDate();
    void attachView(IZhiBoView iZhiBoView);
    void detachView();
}
