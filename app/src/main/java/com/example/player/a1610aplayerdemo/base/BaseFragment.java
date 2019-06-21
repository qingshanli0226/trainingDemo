package com.example.player.a1610aplayerdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public class BaseFragment<T,V extends View> extends Fragment implements BaseView<T> {
    private BasePersenter basePersenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.homeclass_view, null);
        RecyclerView recyclerView = view.findViewById(R.id.homeClass_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return null;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void initData(){

    }

    @Override
    public void onLoadData(T datalist) {

    }

    @Override
    public void onLoadError(int code, String str) {

    }
}
