package com.example.player.a1610aplayerdemo.ui.zhuanlan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;

public class ZhuanLanVideoItem extends LinearLayout {
    ImageView video_img;
    TextView video_title;
    TextView video_price;

    public ZhuanLanVideoItem(Context context) {
        super(context);
        initView(context);
    }
    public ZhuanLanVideoItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.zhuanlan_video_item, this);
        video_img = findViewById(R.id.zhuanlan_video_img);
        video_title = findViewById(R.id.zhualan_video_title);
        video_price = findViewById(R.id.zhualan_video_price);
    }

    public void updateImg(String picUrl) {
        Picasso.get().load(picUrl).into(video_img);
    }
    public void updatetitle(String picUrl) {
        video_title.setText(picUrl);
    }
    public void updateprice(String picUrl) {
        video_price.setText(picUrl);
    }

}
