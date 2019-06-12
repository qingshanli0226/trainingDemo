package com.example.player.a1610aplayerdemo.fragment.selectclass.zl;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

import java.util.List;

public class ZlItemView extends LinearLayout {

    Context m_context;
    GridView m_gridView;

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
        ZL_Item_gv_Adapter zl_item_gv_adapter = new ZL_Item_gv_Adapter();
        zl_item_gv_adapter.refreshData(listBeans);
        m_gridView.setAdapter(zl_item_gv_adapter);
    }
}
