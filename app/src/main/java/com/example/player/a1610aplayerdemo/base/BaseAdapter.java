package com.example.player.a1610aplayerdemo.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public List<T> data=new ArrayList<>();
    public void refresh(List<T> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }
    public T getData(int position){
        return data.get(position);
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        convert(holder,position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(getLayout(),viewGroup,false);
        return new BaseViewHolder(view);
    }
    public abstract int getLayout();
    public abstract void convert(BaseViewHolder baseViewHolder,int i);
    @Override
    public int getItemCount() {
        return data.size();
    }
}
