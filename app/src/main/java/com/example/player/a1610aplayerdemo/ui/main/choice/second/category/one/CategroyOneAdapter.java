package com.example.player.a1610aplayerdemo.ui.main.choice.second.category.one;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.CategoryOneBean;

public class CategroyOneAdapter extends BaseAdapter<CategoryOneBean,CategroyOneView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected CategroyOneView getView(Context context, int i) {
        return new CategroyOneView(context);
    }

    @Override
    protected void setItemView(View itemView, CategoryOneBean categoryOneBean, int i) {
        CategroyOneView categroyOneView = (CategroyOneView) itemView;
        ((CategroyOneView) itemView).setItemData(categoryOneBean);
    }
}
