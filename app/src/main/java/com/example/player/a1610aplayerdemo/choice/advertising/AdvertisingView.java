package com.example.player.a1610aplayerdemo.choice.advertising;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.utils.WidthAndHeight;

public class AdvertisingView extends LinearLayout {
    private TextView tv;
    private LinearLayout linear;
    public AdvertisingView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_advertising, this);
        tv = inflate.findViewById(R.id.advertising_tv);
        linear = inflate.findViewById(R.id.advertising_linear);
        Display display = WidthAndHeight.getHeight().getDisplay();
        int width = display.getWidth();
        ViewGroup.LayoutParams layoutParams = linear.getLayoutParams();
        layoutParams.width = width;
        linear.setLayoutParams(layoutParams);
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
