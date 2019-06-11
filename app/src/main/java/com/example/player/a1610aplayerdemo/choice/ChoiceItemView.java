package com.example.player.a1610aplayerdemo.choice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;

public class ChoiceItemView extends LinearLayout {
    public ChoiceItemView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_choice, this);
    }

    public ChoiceItemView(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ChoiceItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
