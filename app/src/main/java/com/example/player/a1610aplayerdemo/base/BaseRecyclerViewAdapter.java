package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T,V extends View> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {
    private List<T> data = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void updateData(List<T> datalist){
        this.data.clear();
        this.data.addAll(datalist);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        V view = getItemView(viewGroup.getContext(),i);
        return new BaseViewHolder(view);
    }

    protected abstract V getItemView(Context context,int viewtype);

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseRecyclerViewAdapter.BaseViewHolder baseViewHolder, final int i) {
        refreshItemUi((V)baseViewHolder.itemView,data.get(i),i);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(baseViewHolder.itemView,i);
                }
            }
        });
    }

    protected abstract void refreshItemUi(V itemView, T t,int i);



    protected class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

}