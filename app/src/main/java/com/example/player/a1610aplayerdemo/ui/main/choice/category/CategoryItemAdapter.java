package com.example.player.a1610aplayerdemo.ui.main.choice.category;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

public class CategoryItemAdapter extends BaseAdapter<MainBean.HomeCategoryBean,CategoryItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected CategoryItemView getView(Context context, int i) {
        return new CategoryItemView(context);
    }

    @Override
    protected void setItemView(View itemView, MainBean.HomeCategoryBean homeCategoryBean, int i) {
        CategoryItemView categoryItemView = (CategoryItemView) itemView;
        categoryItemView.setItemCategory(homeCategoryBean,i);
    }

}
