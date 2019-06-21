package com.example.player.a1610aplayerdemo.ui.home.adapter.zllist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;

public class ZlListView extends LinearLayout {

    public ZlListView(Context context) {
        super(context);
        initView(context);
    }

    public ZlListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ZlListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_zllist,this);
    }

}