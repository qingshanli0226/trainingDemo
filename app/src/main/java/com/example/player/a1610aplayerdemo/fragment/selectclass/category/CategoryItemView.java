package com.example.player.a1610aplayerdemo.fragment.selectclass.category;

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

public class CategoryItemView extends LinearLayout {

    Context m_context;
    GridView m_gridView;

    public CategoryItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }

    public CategoryItemView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;

    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categroy,this);
        m_gridView = view.findViewById(R.id.categroy_grideview);
    }

    public void setCategoryData(List<GetHomeBean.DataBean.HomeCategoryBean> categoryBeans){
        Category_Item_gv_Adapter adapter = new Category_Item_gv_Adapter();
        adapter.refreshData(categoryBeans);
        m_gridView.setAdapter(adapter);
    }
}
