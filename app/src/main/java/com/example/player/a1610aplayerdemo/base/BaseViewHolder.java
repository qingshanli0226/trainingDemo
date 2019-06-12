package com.example.player.a1610aplayerdemo.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewSparseArray=new SparseArray<>();
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public <T extends View>T getView(int id){
        View v;
        v=viewSparseArray.get(id);
        if (v == null) {
            v=itemView.findViewById(id);
            if (v != null) {
                viewSparseArray.put(id,v);
            }
        }
        return (T) v;

    }
}
