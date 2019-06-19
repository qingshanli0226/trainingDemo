package com.example.player.a1610aplayerdemo.mvvm.databinding.book;

import java.util.List;

public interface IBookView {
    //返回列表书的总价格
    void onGetBooksTotalPrice(Float price);
    void onGetMovementBooksTotalPrice(Float price);
    void onGetBookList(List<BookBean> bookBeans);
    void onGetBookFailed(int code, String message);
}
