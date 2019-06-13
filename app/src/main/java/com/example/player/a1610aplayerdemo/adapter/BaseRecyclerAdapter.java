package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter <T> extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>{

    private List<T> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private int layId;


    public BaseRecyclerAdapter(List<T> list, Context context, int layId) {
        this.list = list;
        this.context = context;
        this.layId = layId;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(layId, viewGroup, false);
        return new BaseViewHolder(view);
    }


    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        refreshItemUi(baseViewHolder,list.get(i));
    }
    public abstract  void refreshItemUi(BaseViewHolder holder,T itemData);


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

