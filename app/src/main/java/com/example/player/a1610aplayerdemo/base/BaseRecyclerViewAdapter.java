package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T , V extends View> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<T> datas = new ArrayList<>();

    public void refreshData(List<T> list){
        datas.clear();
        datas.addAll(list);
        notifyDataSetChanged();
    }

    protected abstract V getItemViewHodler(ViewGroup viewGroup, Context context,int viewType);
    protected abstract void setItemViewHolder(V view,T data,int positon);
//    protected abstract int getViewType(int positon);


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        V view = getItemViewHodler(viewGroup,viewGroup.getContext(),i);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        setItemViewHolder((V)(viewHolder.itemView),datas.get(i),i);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iItemViewClick != null){
                    iItemViewClick.onItemClik();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private class BaseViewHolder extends RecyclerView.ViewHolder{
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private IItemViewClick iItemViewClick;

    public void setiItemViewClick(IItemViewClick iItemViewClick) {
        this.iItemViewClick = iItemViewClick;
    }

    public interface IItemViewClick{
        void onItemClik();
    }
}
