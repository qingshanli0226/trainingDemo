package com.example.player.a1610aplayerdemo.ui.main.choice.zl;

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

public class ZLView extends LinearLayout {

    private TextView tv;
    private RecyclerView recyclerView;
    private ZLItemAdapter adapter;
    private Context context;

    public ZLView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_zl, this);
        tv = inflate.findViewById(R.id.zl_more);
        recyclerView = inflate.findViewById(R.id.zl_recycler);
    }

    public ZLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;

    }

    public ZLView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;
    }

    public void setZLView(List<MainBean.ZlListBean> zlListBeans){
        adapter = new ZLItemAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        adapter.updataData(zlListBeans);

        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 专栏更多");
            }
        });
    }

}
