package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 这是一个适配器基类
 * 我们不能确定布局和数据  所以需要子类来实现  其他的  都已经抽取出来   （也就是公共的部分）
 *
 * @param <T>
 * @param <V>
 */
public abstract class BaseAdapter<T, V extends View> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> list = new ArrayList<>();
    private IMyClick iMyClick;//点击事件的接口

    //刷新数据
    public void updataData(List<T> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    protected abstract int getViewType(int position);


    public void setiMyClick(IMyClick iMyClick) {
        this.iMyClick = iMyClick;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        V view = getView(viewGroup.getContext(), i);
        return new BaseViewHolder(view);
    }

    //让子类生成布局
    protected abstract V getView(Context context, int i);

    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder baseViewHolder, final int i) {
        //刷新  设置数据等   对于UI的操作
        setItemView((V) (baseViewHolder.itemView), list.get(i), i);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iMyClick != null) {
                    iMyClick.onItemClick(baseViewHolder.itemView, i);
                }
            }
        });
    }

    //去子类刷新view
    protected abstract void setItemView(View itemView, T t, int i);

    @Override
    public int getItemCount() {
        return list.size();
    }

}
