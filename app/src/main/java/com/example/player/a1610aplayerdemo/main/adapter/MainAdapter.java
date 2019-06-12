package com.example.player.a1610aplayerdemo.main.adapter;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

public class MainAdapter extends BaseRecyclerViewAdapter<Object, View> {
    @Override
    public View getItemView(Context context, int viewType) {
        return null;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    protected void refreshItemUi(View itemView, Object o, int position) {
        switch (position) {
            case 0:
                updatePositionZero(itemView, o);
                break;
        }
    }

    private void updatePositionZero(View itemView, Object o) {
        //第一步 将itemview转换成第一个viewtype

        //第二步 将数据转换成相应的数据

        //第三步 刷新数据
    }
}
