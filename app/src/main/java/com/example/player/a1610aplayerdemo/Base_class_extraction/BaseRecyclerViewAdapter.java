package com.example.player.a1610aplayerdemo.Base_class_extraction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder>{
    private List<T> data = new ArrayList<>();

    public void updateData(List<T> dataList) {
        this.data.clear();
        this.data.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        V itemView = getItemView(viewGroup.getContext(), viewType);
        return new BaseViewHolder(itemView);
    }


    protected abstract V getItemView(Context context, int viewType);


    public void onBindViewHolder(@NonNull final BaseViewHolder baseViewHolder, final int i) {
        refreshItemUi((V)baseViewHolder.itemView,data.get(i),i);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(baseViewHolder.itemView, i);
                }
            }
        });
    }

    protected abstract void refreshItemUi(View itemView, T t, int i);

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    protected abstract int getViewType(int position);


    protected class  BaseViewHolder extends RecyclerView.ViewHolder{
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
