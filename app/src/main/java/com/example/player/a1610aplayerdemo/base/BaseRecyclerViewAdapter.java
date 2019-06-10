package com.example.player.a1610aplayerdemo.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * 使用adapter基类，提取共性的内容
 * 两个变化，一个是管理的数据类型， 另一个是布局装换的itemview
 * 将这两个变化使用泛型来兼容不同的数据类型和 itemview
 *
 */

public abstract class BaseRecyclerViewAdapter<T,V extends View> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder>{


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {

    }

    protected class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
