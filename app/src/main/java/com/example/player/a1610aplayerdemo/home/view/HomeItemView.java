package com.example.player.a1610aplayerdemo.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

public class HomeItemView extends LinearLayout {
    ImageView imageView;

    public HomeItemView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_home_layout,this);
        imageView = findViewById(R.id.image);
    }

    public HomeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void updateImg(String picUrl){
        Picasso.with(getContext()).load(picUrl).into(imageView);
    }

    public HomeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}