package com.example.player.a1610aplayerdemo.mvvm.databinding.book;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.BR;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public class BookActivity extends AppCompatActivity implements IBookView{
    private IBookViewMode iBookViewMode;
    private ViewDataBinding activityBookBinding;
    private BookRecyclerviewAdapter bookRecyclerviewAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBookBinding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        iBookViewMode = new BookViewMode();
        iBookViewMode.attachView(this);
        initBookRv();

        initData();
    }

    private void initBookRv() {
        bookRecyclerviewAdapter = new BookRecyclerviewAdapter();
        RecyclerView rvBook = activityBookBinding.getRoot().findViewById(R.id.rvBook);
        rvBook.setLayoutManager(new LinearLayoutManager(this));
        rvBook.setAdapter(bookRecyclerviewAdapter);
    }

    private void initData() {
        iBookViewMode.getBooks();
        iBookViewMode.getMovements();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iBookViewMode.detachView();
    }

    @Override
    public void onGetBooksTotalPrice(Float price) {
        activityBookBinding.setVariable(BR.totalPrice, price);//设置总价格
    }

    @Override
    public void onGetMovementBooksTotalPrice(Float price) {
        activityBookBinding.setVariable(BR.totalMovementPrice, price);
    }

    @Override
    public void onGetBookList(List<BookBean> bookBeans) {
         bookRecyclerviewAdapter.upadateBooks(bookBeans);
    }

    @Override
    public void onGetBookFailed(int code, String message) {
        Toast.makeText(this, "获取书本数据失败:" + message, Toast.LENGTH_SHORT).show();
    }
}
