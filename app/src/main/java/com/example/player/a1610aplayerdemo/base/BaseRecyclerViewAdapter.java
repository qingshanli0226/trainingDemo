package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用adapter基类，提取共性的内容。
 * 两个变化，一个是管理的数据类型，另一是布局转换的itemView
 * 将这两个变化使用泛型来兼容不同的数据类型和itemview
 * @param <T>
 * @param <V>
 */
public abstract class BaseRecyclerViewAdapter<T, V extends View>  extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private List<T> data = new ArrayList<>();//定义一个数据列表.
    private OnItemClickListener onItemClickListener;//维护一个点击回调接口

    //更新数据
    public void updateData(List<T> dataList) {
        this.data.clear();
        this.data.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        V view = getItemView(viewGroup.getContext(), viewType);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseRecyclerViewAdapter.BaseViewHolder baseViewHolder, final int position) {
        refreshItemUi((V)baseViewHolder.itemView, data.get(position), position);

        //回调点击事件
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(baseViewHolder.itemView, position);
                }
            }
        });
    }


    //因为生成itemView需要上下文，所以添加一个参数，就是上下文参数, 并且返回值只要是集成View即可,不需要指定返回的具体类型.
    public abstract V getItemView(Context context, int viewType);

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    //根据position 传递不同viewType
    public abstract int getViewType(int position);


    /* *//**
     * 在UI上渲染数据
     * @param baseViewHolder
     * @param position
     *//*
    @Override
    public void onBindViewHolder(final BaseViewHolder baseViewHolder, final int position) {
         refreshItemUi((V)baseViewHolder.itemView, data.get(position));

         //回调点击事件
         baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (onItemClickListener != null) {
                     onItemClickListener.onItemClick(baseViewHolder.itemView, position);
                 }
             }
         });
    }*/

    /**
     * 在子类中去刷新UI
     * @param itemView
     * @param t
     */
    protected abstract void refreshItemUi(V itemView, T t, int position);

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


}
