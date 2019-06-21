package com.example.player.a1610aplayerdemo.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> views = new SparseArray<>();
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public <T extends View> T getView(int id){
        View view;
        view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            if (view != null) {
                views.put(id, view);//存储起来.可以提高性能.
            }
        }
        return (T) view;
    }

}
