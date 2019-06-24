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

public abstract class BaseFragment<T, V extends View> extends Fragment {

    private RecyclerView recyclerView;
    private BaseRecyclerViewAdapter baseRecyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = this.getContentView(inflater,container);
        return view;
    }

    protected abstract View getContentView(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
