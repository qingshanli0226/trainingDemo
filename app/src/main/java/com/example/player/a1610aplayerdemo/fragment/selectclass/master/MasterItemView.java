package com.example.player.a1610aplayerdemo.fragment.selectclass.master;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

import java.util.List;

public class MasterItemView extends LinearLayout {

    Context m_context;
    RecyclerView m_rv;

    public MasterItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }



    public MasterItemView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_master_live, this);
        m_rv = view.findViewById(R.id.master_rv);
    }

    public void setData(List<GetHomeBean.DataBean.MasterLivesBean> livesBeans){
        Master_Rv_adapter master_rv_adapter = new Master_Rv_adapter();
        master_rv_adapter.upData(livesBeans);
        LinearLayoutManager manager = new LinearLayoutManager(m_context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        m_rv.setLayoutManager(manager);
        m_rv.setAdapter(master_rv_adapter);
    }

}
