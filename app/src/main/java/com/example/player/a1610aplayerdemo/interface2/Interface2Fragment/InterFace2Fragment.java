package com.example.player.a1610aplayerdemo.interface2.Interface2Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.interface2.presenter.InterFacePresenter;

public class InterFace2Fragment extends Fragment implements IBaseView {
    private IBasePresenter iBasePresenter;
    private String url;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_interface,container,false);
        Bundle bundle=getArguments();
        url=bundle.getString("url");
        iBasePresenter=new InterFacePresenter(url);
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        return view;
    }

    @Override
    public void onLoadData(Object data) {

    }

    @Override
    public void onLoadError(String message) {

    }
}
