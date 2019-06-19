package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<R> {
    void loadDataByGet();
    void attchView(IBaseView<R> iBaseView);
    void detachView();
}
