package com.example.player.a1610aplayerdemo.mvvm.databinding.book;

public interface IBookViewMode {
    void getBooks();
    void getMovements();
    void attachView(IBookView iBookView);
    void detachView();
}
