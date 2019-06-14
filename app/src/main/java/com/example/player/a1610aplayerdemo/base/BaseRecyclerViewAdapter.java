package com.example.player.a1610aplayerdemo.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseRecyclerViewAdapter<T,V extends View> {


    class BaseViewHolder extends RecyclerView.ViewHolder{
        public BaseViewHolder(View itemView){
            super(itemView);
        }
    }




}
