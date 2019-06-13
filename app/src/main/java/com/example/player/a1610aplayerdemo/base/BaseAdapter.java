package com.example.player.a1610aplayerdemo.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    public List<T> data = new ArrayList<>();

    public void refreshData(List<T> dataList) {
        data.clear();
        data.addAll(dataList);
        notifyDataSetChanged();
    }

    public T getData(int position) {
        return data.get(position);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rootView = inflater.inflate(getLayoutId(), viewGroup, false);
        return new BaseViewHolder(rootView);
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, final int i) {
        convert(baseViewHolder, i);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onckitem.dianji(i);
            }
        });
    }

    protected abstract void convert(BaseViewHolder baseViewHolder, int i);

    @Override
    public int getItemCount() {
        return data.size();
    }

    Onckitem onckitem;

    public void setOnckitem(Onckitem onckitem) {
        this.onckitem = onckitem;
    }

    public interface Onckitem{
        void dianji(int i);
    }

}
