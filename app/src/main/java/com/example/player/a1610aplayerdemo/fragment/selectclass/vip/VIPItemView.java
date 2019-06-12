package com.example.player.a1610aplayerdemo.fragment.selectclass.vip;

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

public class VIPItemView extends LinearLayout {

    Context m_context;
    GridView m_grideView;

    public VIPItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vip,this);
        m_grideView = view.findViewById(R.id.vpi_gridview);
    }

    public VIPItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
    }

    public void setGrideViewData(List<GetHomeBean.DataBean.VipRecommendBean> list){
          VIP_Item_gv_Adapter courese_item_gv_adapter = new VIP_Item_gv_Adapter();
          courese_item_gv_adapter.refreshData(list);
            m_grideView.setAdapter(courese_item_gv_adapter);
    }
}
