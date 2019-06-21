package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T,v extends View> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<T> list=new ArrayList<>();
    public void refresh(List<T> lists){
        list.clear();
        list.addAll(lists);
        notifyDataSetChanged();
    }

    protected abstract v getItemViewHolder(ViewGroup viewGroup, Context context,int ViewType);

    protected abstract void setItemViewHolder(v view,T data,int position);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v view =getItemViewHolder(viewGroup,viewGroup.getContext(),i);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        setItemViewHolder((v)viewHolder.itemView,list.get(i),i);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickItem != null) {
                    itemClickItem.onItemClick(viewHolder.itemView,list.get(i),i);
                }
            }
        });
    }
    private class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    private IItemClickItem<T> itemClickItem;

    public void setItemClickItem(IItemClickItem<T> itemClickItem) {
        this.itemClickItem = itemClickItem;
    }

    public interface IItemClickItem<T>{
        void onItemClick(View item,T data,int position);
    }
}
