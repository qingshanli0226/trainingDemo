package com.example.player.a1610aplayerdemo.member.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

public class MemberItemView extends LinearLayout {
    ImageView imageView;
    public MemberItemView(Context context) {
        super(context);
        initView(context);
    }

    public MemberItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_member01, this);
        imageView = findViewById(R.id.Member_iv1);
    }

    public void updateImg(String picUrl) {
        Picasso.get().load(picUrl).into(imageView);
    }

    public MemberItemView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
