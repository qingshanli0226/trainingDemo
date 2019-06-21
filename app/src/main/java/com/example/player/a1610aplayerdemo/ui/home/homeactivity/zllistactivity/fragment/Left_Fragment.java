package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.bean.ZlListBean;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.presenter.HomeFourPeresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Left_Fragment extends Fragment implements IBaseView {
    private IBasePresenter iBasePresenter;
    private List<ZlListBean.DataBean> list = new ArrayList<>();
    private TextView homefourleftTitle;
    private ImageView homefourleftImage;
    private TextView homefourleftName;
    private TextView homefourleftMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.homefour_fragmentleft, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        iBasePresenter = new HomeFourPeresenter(id);
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
    }

    private void initView(View view) {
        homefourleftTitle = (TextView) view.findViewById(R.id.homefourleft_title);
        homefourleftImage = (ImageView) view.findViewById(R.id.homefourleft_image);
        homefourleftName = (TextView) view.findViewById(R.id.homefourleft_name);
        homefourleftMessage = (TextView) view.findViewById(R.id.homefourleft_message);
    }

    @Override
    public void onLoadData(List data) {
        list.addAll(data);
        homefourleftTitle.setText(list.get(0).getTitle());
        Picasso.get().load(list.get(0).getTeacherAvatar()).into(homefourleftImage);
        homefourleftName.setText(list.get(0).getTeacherName());
        homefourleftMessage.setText(list.get(0).getIntroduce());
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onLoadObject(Object data) {

    }
}