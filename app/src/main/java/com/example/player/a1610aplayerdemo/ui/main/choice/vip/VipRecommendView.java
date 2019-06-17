package com.example.player.a1610aplayerdemo.ui.main.choice.vip;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;

import java.util.List;

public class VipRecommendView extends LinearLayout {

    private TextView more;
    private RecyclerView recyclerView;

    public VipRecommendView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_vip, this);
        more = inflate.findViewById(R.id.vip_more);
        recyclerView = inflate.findViewById(R.id.vip_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
    }

    public VipRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public VipRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setVipData(List<MainBean.VipRecommendBean> vipData){
        VipRecommendItemAdapter vipRecommendItemAdapter = new VipRecommendItemAdapter();
        recyclerView.setAdapter(vipRecommendItemAdapter);
        vipRecommendItemAdapter.updataData(vipData);
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: VIP更多");
            }
        });
    }
}

