package com.example.player.a1610aplayerdemo.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.SelectClassAdapter;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.home.persenter.HomeData;
import com.example.player.a1610aplayerdemo.home.persenter.HomePersenter;
import com.example.player.a1610aplayerdemo.home.view.HomeView;
import com.example.player.a1610aplayerdemo.util.Contants;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment01 extends Fragment implements HomeView {


    private ImageView cursePageTopBtn;
    private RelativeLayout searchView;
    private RecyclerView rv;
    private SwipeRefreshLayout refreshLayout;
    private SharedPreferences sharedPreferences;
    private String token;
    private HomeBean homeBean;


    public BlankFragment01() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment01, container, false);

        initView(view);
        return view;

    }

    private void initView(View view) {
        cursePageTopBtn = (ImageView) view.findViewById(R.id.cursePageTopBtn);
        searchView = (RelativeLayout) view.findViewById(R.id.searchView);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        //Token
        sharedPreferences = getActivity().getSharedPreferences(Contants.TOKEN, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(Contants.TOKEN,"");
        Log.d("tokennnnnn",""+token);
        new HomePersenter(this).getData(token);

    }

    @Override
    public void onLoadData(Object data) {
        homeBean= (HomeBean) data;
        Log.d("aaaaaa",""+homeBean.getCode());

        SelectClassAdapter selectClassAdapter = new SelectClassAdapter(homeBean, getActivity());
        rv.setAdapter(selectClassAdapter);
    }

    @Override
    public void onErrorData(String errorString) {
      Log.d("errorrrrhome",""+errorString);
    }
}
