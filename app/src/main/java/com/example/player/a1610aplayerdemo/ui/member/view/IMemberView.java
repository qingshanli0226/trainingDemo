package com.example.player.a1610aplayerdemo.ui.member.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

public class IMemberView extends LinearLayout {
    private ImageView imageView;

    public IMemberView(Context context) {
        super(context);
        initView(context);
    }

    public IMemberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public IMemberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_member_layout,this);
        imageView = findViewById(R.id.member_image_layout);
    }

    public void updateImg(String picUrl){
        Picasso.get().load(picUrl).into(imageView);
    }

}