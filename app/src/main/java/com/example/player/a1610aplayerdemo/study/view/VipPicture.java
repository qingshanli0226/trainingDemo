package com.example.player.a1610aplayerdemo.study.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

public class VipPicture extends LinearLayout {
    ImageView imageView;


    public VipPicture(Context context) {
        super(context);
        initView(context);
    }

    public VipPicture(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.vip_item, this);
        imageView = findViewById(R.id.vip_niv_picture);
    }

    public void updateImg(String picUrl) {
        Picasso.with(MVPApplication.instance).load(picUrl).into(imageView);
    }

    public VipPicture(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
