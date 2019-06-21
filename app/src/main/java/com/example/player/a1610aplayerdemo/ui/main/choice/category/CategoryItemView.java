package com.example.player.a1610aplayerdemo.ui.main.choice.category;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.ui.main.choice.second.CategoryOneActivity;
import com.squareup.picasso.Picasso;

public class CategoryItemView extends LinearLayout {

    private TextView tv;
    private ImageView iv;
    private Context context;

    public CategoryItemView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_category_item, this);
        tv = inflate.findViewById(R.id.category_tv);
        iv = inflate.findViewById(R.id.category_iv);
    }

    public CategoryItemView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;
    }

    public CategoryItemView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;
    }

    public void setItemCategory(MainBean.HomeCategoryBean homeCategoryBean,int i){
        tv.setText(homeCategoryBean.getTitle());
        Picasso.with(context).load(homeCategoryBean.getBannerUrl()).into(iv);
        final int a = i;
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick:种类 "+a);
                if(a == 0){
                    Intent intent = new Intent(getContext(), CategoryOneActivity.class);
                    getContext().startActivity(intent);
                }
            }
        });
    }
}
