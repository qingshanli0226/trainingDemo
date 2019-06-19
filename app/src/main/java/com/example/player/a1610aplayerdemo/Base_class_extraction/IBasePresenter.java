package com.example.player.a1610aplayerdemo.Base_class_extraction;

public interface IBasePresenter<R>{
    void loadDataByGet();
    void attachView(IBaseView<R> iBaseView);
    void detachView();
}
