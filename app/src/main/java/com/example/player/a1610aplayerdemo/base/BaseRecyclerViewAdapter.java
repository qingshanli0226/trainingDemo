package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.ui.adapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private List<T> list=new ArrayList<>();
    private Context context;
    private int type;

    public BaseRecyclerViewAdapter(List<T> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(type, viewGroup, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
            refreshItemUi(baseViewHolder,list.get(i),i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public abstract void refreshItemUi(BaseViewHolder holder,T itemData,int position);

    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
