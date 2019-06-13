package com.example.player.a1610aplayerdemo.choice.zl;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.squareup.picasso.Picasso;

public class ZLItemView extends LinearLayout {

    private ImageView iv;
    private TextView tv;
    private Context context;

    public ZLItemView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_zl_item, this);
        iv = inflate.findViewById(R.id.zl_iv);
        tv = inflate.findViewById(R.id.zl_title);

    }

    public ZLItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;

    }

    public ZLItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;

    }

    public void setZLItem(MainBean.ZlListBean zlListBean,int i){
        String title = zlListBean.getTitle();
        String image = zlListBean.getImage();
        Picasso.with(context).load(image).into(iv);
        tv.setText(title);
        final int a = i;
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 专栏"+a);
            }
        });
    }
}
