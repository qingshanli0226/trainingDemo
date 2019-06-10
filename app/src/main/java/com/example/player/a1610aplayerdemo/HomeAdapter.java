package com.example.player.a1610aplayerdemo;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.view.HomeItemView;

public class HomeAdapter extends BaseRecyclerViewAdapter<String, HomeItemView> {

    @Override
    public HomeItemView getItemView(Context context) {
        return new HomeItemView(context);
    }

    @Override
    protected void refreshItemUi(HomeItemView itemView, String s) {

    }
}
