package com.example.player.a1610aplayerdemo.ui.main.choice.second.category.one;

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
import com.example.player.a1610aplayerdemo.bean.CategoryOneBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategroyOneView extends LinearLayout {
    private ImageView iv;
    private TextView tv;
    private Context context;
    public CategroyOneView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public CategroyOneView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }


    public CategroyOneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_category_one_item, this);
        iv = inflate.findViewById(R.id.one_iv);
        tv = inflate.findViewById(R.id.one_tv);
    }

    public void setItemData(CategoryOneBean categoryOneBean){
        String image = categoryOneBean.getImage();
        String shortName = categoryOneBean.getShortName();

        Picasso.with(context).load(image).into(iv);
        tv.setText(shortName);

//        Log.e("ynynyn", "setItemView: "+categoryOneBean.getShortName());

    }

}
