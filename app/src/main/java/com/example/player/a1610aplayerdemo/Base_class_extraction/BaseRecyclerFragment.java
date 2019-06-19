package com.example.player.a1610aplayerdemo.Base_class_extraction;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;

public class BaseRecyclerFragment<T,V extends View> extends Fragment implements IBaseView<T>{

    private  BaseRecyclerViewAdapter baseRecyclerViewAdapter;

    @Override
    public void onLoadDataList(List<T> date) {

    }

    @Override
    public void onLoadDateBean(T date) {

    }

    @Override
    public void onLoadEeeor(int code, String message) {

    }
}
