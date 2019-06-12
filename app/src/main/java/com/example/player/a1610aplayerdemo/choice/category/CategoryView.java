package com.example.player.a1610aplayerdemo.choice.category;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.MainBean;

import java.util.List;

public class CategoryView extends LinearLayout {

    private RecyclerView recyclerView;
    private CategoryItemAdapter categoryItemAdapter;

    public CategoryView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_category, this);
        recyclerView = inflate.findViewById(R.id.category_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));

    }

    public CategoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CategoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setCategoryData(List<MainBean.HomeCategoryBean> categoryBeans){
        categoryItemAdapter = new CategoryItemAdapter();
        recyclerView.setAdapter(categoryItemAdapter);
        categoryItemAdapter.updataData(categoryBeans);
    }


}
