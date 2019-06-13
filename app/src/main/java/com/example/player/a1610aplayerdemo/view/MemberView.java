package com.example.player.a1610aplayerdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.util.MyApplication;

public class MemberView extends LinearLayout{

    ImageView imageView;

    public MemberView(Context context) {
        super(context);
        initView(context);
    }

    public MemberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.member_item,this);
        imageView = findViewById(R.id.memberimg);
    }




    public void  updateData(String picUrl){
        Glide.with(MyApplication.application).load(picUrl).into(imageView);
    }

    public MemberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
