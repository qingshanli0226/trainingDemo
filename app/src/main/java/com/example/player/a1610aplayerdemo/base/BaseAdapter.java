package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, V extends View> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> list = new ArrayList<>();
    private IMyClick iMyClick;

    public void setiMyClick(IMyClick iMyClick) {
        this.iMyClick = iMyClick;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        V view = getView(viewGroup.getContext());
        return new BaseViewHolder(view);
    }

    abstract V getView(Context context);

    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder baseViewHolder, final int i) {
        setItemView(baseViewHolder.itemView, i);

        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iMyClick != null) {
                    iMyClick.onItemClick(baseViewHolder.itemView, i);
                }
            }
        });
    }

    abstract void setItemView(View itemView, int i);

    @Override
    public int getItemCount() {
        return list.size();
    }

}
