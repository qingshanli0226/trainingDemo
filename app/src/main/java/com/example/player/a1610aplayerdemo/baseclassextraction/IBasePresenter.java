package com.example.player.a1610aplayerdemo.baseclassextraction;

public interface IBasePresenter<R>{
    void loadDataByGet();
    void attachView(IBaseView<R> iBaseView);
    void detachView();
}
