package com.example.player.a1610aplayerdemo.twomenuActivity.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.twomenuActivity.bean.BannerBean;
import com.example.player.a1610aplayerdemo.twomenuActivity.persenter.VedioPersenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThisClassFragment extends Fragment implements BaseView<BannerBean> {

    private TextView textTitle;
    private WebView webview;

    public ThisClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_this_class, container, false);
        initView(view);

        return view;

    }

    private void initView(View view) {
        textTitle = (TextView) view.findViewById(R.id.textTitle);
        webview = (WebView) view.findViewById(R.id.webview);

        Intent intent = getActivity().getIntent();
        String relation = intent.getStringExtra("relation");
        new VedioPersenter(this).getVedioData(relation,"0");

    }

    @Override
    public void onLoadData(BannerBean datalist) {

    }

    @Override
    public void onLoadError(int code, String str) {

    }
}
