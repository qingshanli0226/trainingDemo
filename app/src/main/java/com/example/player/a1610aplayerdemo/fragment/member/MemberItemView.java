package com.example.player.a1610aplayerdemo.fragment.member;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

class MemberItemView extends LinearLayout {
    ImageView imageView;
    Context m_context;


    public MemberItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);

    }

    public MemberItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
        initView(context);

    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_member, this);
        imageView = inflate.findViewById(R.id.item_member_img);
    }
   public void updateImg(String picUrl){
       Glide.with(m_context).load(picUrl).into(imageView);

//       Picasso.get().load(picUrl).into(imageView);
    }

}
