package com.example.player.a1610aplayerdemo.curriculum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

public class HourView extends LinearLayout {
    TextView textView1,textView2;

    public HourView(Context context) {
        super(context);
        initView(context);
    }

    public HourView(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hour_item,this);
        textView1 = findViewById(R.id.hour_tv1);
        textView2 = findViewById(R.id.hour_tv2);
    }

    public void updataText(String s1,String s2){
        textView1.setText(s1);
        textView2.setText(s2);
    }

    public HourView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
