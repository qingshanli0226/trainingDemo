package com.example.player.a1610aplayerdemo.ui.main.choice.vip;

import android.content.Context;
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

class VipRecommendItemView extends LinearLayout {

    private Context context;
    private TextView title;
    private TextView text;
    private ImageView iv;

    public VipRecommendItemView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_vip_item, this);
        iv = inflate.findViewById(R.id.vip_iv);
        title = inflate.findViewById(R.id.vip_title);
        text = inflate.findViewById(R.id.vip_text);
    }

    public VipRecommendItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;
    }

    public VipRecommendItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;
    }
    public void setItem(MainBean.VipRecommendBean vipRecommendBean,int i){
        String text1 = vipRecommendBean.getText1();
        text.setText(text1);
        String title = vipRecommendBean.getTitle();
        this.title.setText(title);
        String image = vipRecommendBean.getImage();
        Picasso.with(context).load(image).into(iv);

        final int a = i;

        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 会员专享"+a);
            }
        });
    }
}
