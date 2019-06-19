package com.example.player.a1610aplayerdemo.mvvm.databinding.book;

import com.example.player.a1610aplayerdemo.mvvm.databinding.base.IDataListener;
import com.example.player.a1610aplayerdemo.mvvm.databinding.base.IMode;

import java.util.List;

public class BookViewMode implements IBookViewMode{
    private IBookView iBookView;
    private IMode<List<BookBean>> iBookMode = new BookMode();
    private IMode<List<MovementBean>> iMovementMode = new MovementMode();



    public BookViewMode() {
    }

    @Override
    public void getBooks() {
        iBookMode.getData(new IDataListener<List<BookBean>>() {
            @Override
            public void onGetData(List<BookBean> data) {
                //计算书本价格之和
                float totalBookPrice = 0;
                for(BookBean bean:data) {
                    totalBookPrice += Float.valueOf(bean.getPrice());
                }
                iBookView.onGetBooksTotalPrice(totalBookPrice);
                //第二步把获取的的书本列表数据传给view层。
                iBookView.onGetBookList(data);
            }

            @Override
            public void onGetDataFailed(int code, String message) {
                iBookView.onGetBookFailed(code, message);
            }
        });
    }

    @Override
    public void getMovements() {
        iMovementMode.getData(new IDataListener<List<MovementBean>>() {
            @Override
            public void onGetData(List<MovementBean> data) {
                 //计算书本价格之和
                float totalBookPrice = 0;
                for(MovementBean bean:data) {
                    totalBookPrice += Float.valueOf(bean.getPrice());
                }
                iBookView.onGetMovementBooksTotalPrice(totalBookPrice);
            }

            @Override
            public void onGetDataFailed(int code, String message) {
                iBookView.onGetBookFailed(code, message);
            }
        });
    }

    @Override
    public void attachView(IBookView iBookView) {
        this.iBookView = iBookView;
    }

    @Override
    public void detachView() {
        iBookView = null;
    }

}
