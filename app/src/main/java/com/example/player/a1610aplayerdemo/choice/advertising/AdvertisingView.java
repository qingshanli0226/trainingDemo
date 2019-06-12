package com.example.player.a1610aplayerdemo.choice.advertising;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

public class AdvertisingView extends LinearLayout {
    private TextView tv;
    public AdvertisingView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_advertising, this);
        tv = inflate.findViewById(R.id.advertising_tv);
    }

    public AdvertisingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AdvertisingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
}
