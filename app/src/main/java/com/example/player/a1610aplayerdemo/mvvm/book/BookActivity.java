package com.example.player.a1610aplayerdemo.mvvm.book;

//import android.databinding.DataBindingUtil;
//import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
//import com.example.player.a1610aplayerdemo.BR;
//import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public class BookActivity extends AppCompatActivity {
//    private IBookViewMode iBookViewMode;
//    private ViewDataBinding activityBookBinding;
//    private BookRecyclerviewAdapter bookRecyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityBookBinding= DataBindingUtil.setContentView(this,R.layout.activity_book);
//        iBookViewMode=new BookViewMode();
//        iBookViewMode.attachView(this);
//        initBookRv();
//        initData();
    }

    private void initData() {
//        iBookViewMode.getBooks();
//        iBookViewMode.getMovements();
    }

    private void initBookRv() {
//            bookRecyclerviewAdapter=new BookRecyclerviewAdapter();
//        RecyclerView recyclerView=activityBookBinding.getRoot().findViewById(R.id.rvBook);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(bookRecyclerviewAdapter);
    }

//    @Override
//    public void onGetBooksTotalPrice(Float f) {
//        activityBookBinding.setVariable(BR.totalMovementPrice,f);
//
//    }
//
//    @Override
//    public void onGetMoveMentBooksTotalprice(Float f) {
//
//    }
//
//    @Override
//    public void onGetBookList(List<BookBean> bookBeans) {
//        bookRecyclerviewAdapter.upadateBooks(bookBeans);
//    }
//
//    @Override
//    public void onGetBookFailed(int code, String error) {
//        Toast.makeText(this, "获取书本数据失败:" + error, Toast.LENGTH_SHORT).show();
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//    }

}
