package com.example.player.a1610aplayerdemo.fragment.selectclass.zl;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.ZLvideoActivity;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.onclickinterface.OnclickListener;

import java.util.ArrayList;
import java.util.List;

public class ZlItemView extends LinearLayout implements OnclickListener {

    Context m_context;
    GridView m_gridView;
private List<GetHomeBean.DataBean.ZlListBean> listBeans = new ArrayList<>();
    public ZlItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }

    public ZlItemView(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;

    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zl,this);
        m_gridView = view.findViewById(R.id.zl_gridview);
    }

    public void setGrideViewData(List<GetHomeBean.DataBean.ZlListBean> listBeans){
        this.listBeans.clear();
        this.listBeans.addAll(listBeans);
        ZL_Item_gv_Adapter zl_item_gv_adapter = new ZL_Item_gv_Adapter();
        zl_item_gv_adapter.refreshData(listBeans);
        zl_item_gv_adapter.setOnclickListener(this); // 设置点击事件返回下标然后从 数据集合list 中按下标获取具体哪个类
        m_gridView.setAdapter(zl_item_gv_adapter);
    }

    @Override
    public void onClick(int position) {
        int id = listBeans.get(position).getId();
        Intent intent = new Intent();
        intent.setClass(m_context, ZLvideoActivity.class);
        intent.putExtra("id",id+"");
        m_context.startActivity(intent);
    }

}
