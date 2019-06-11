package com.example.player.a1610aplayerdemo.choice;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

public class ChoiceAdapter extends BaseAdapter<MainBean,ChoiceItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected ChoiceItemView getView(Context context, int i) {
        return null;
    }

    @Override
    protected void setItemView(View itemView, MainBean mainBean, int i) {

    }


}
