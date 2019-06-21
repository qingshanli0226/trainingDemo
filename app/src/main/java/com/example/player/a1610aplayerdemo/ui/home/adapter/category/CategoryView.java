package com.example.player.a1610aplayerdemo.ui.home.adapter.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;

public class CategoryView extends LinearLayout {

    public CategoryView(Context context) {
        super(context);
        initView(context);
    }

    public CategoryView(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CategoryView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_category,this);
    }


}